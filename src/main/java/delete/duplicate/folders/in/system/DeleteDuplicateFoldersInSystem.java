package delete.duplicate.folders.in.system;


import java.util.*;

/**
 * @author hum
 */
public class DeleteDuplicateFoldersInSystem {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode();
        for (List<String> path : paths) {
            TrieNode cur = root;
            for (String folder : path) {
                if (!cur.children.containsKey(folder)) {
                    cur.children.put(folder, new TrieNode());
                }
                cur = cur.children.get(folder);
            }
        }
        delete(root, new HashMap<>());
        List<List<String>> res = new ArrayList<>();
        dfs(root, new ArrayList<>(), res);
        return res;
    }

    String delete(TrieNode root, Map<String, TrieNode> map) {
        if (root.children.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, TrieNode> e : root.children.entrySet()) {
            String folder = e.getKey();
            TrieNode child = e.getValue();
            list.add('(' + folder + delete(child, map) + ')');
        }
        Collections.sort(list);
        for (String s : list) {
            sb.append(s);
        }
        String serialized = sb.toString();
        if (map.containsKey(serialized)) {
            map.get(serialized).deleted = true;
            root.deleted = true;
        } else {
            map.put(serialized, root);
        }
        return serialized;
    }

    void dfs(TrieNode root, List<String> path, List<List<String>> res) {
        for (Map.Entry<String, TrieNode> e : root.children.entrySet()) {
            String folder = e.getKey();
            TrieNode child = e.getValue();
            if (child.deleted) {
                continue;
            }
            path.add(folder);
            dfs(child, path, res);
            path.remove(path.size() - 1);
        }
        if (!path.isEmpty()) {
            res.add(new ArrayList<>(path));
        }
    }

}

class TrieNode {
    Map<String, TrieNode> children = new HashMap<>();
    boolean deleted;
}
