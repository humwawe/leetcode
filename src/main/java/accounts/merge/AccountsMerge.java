package accounts.merge;

import java.util.*;

/**
 * @author hum
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Node> map = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String s = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                String tmp = account.get(i);
                if (!map.containsKey(tmp)) {
                    map.put(tmp, new Node());
                    map.get(tmp).parent = map.get(tmp);
                    map.get(tmp).name = name;
                    map.get(tmp).email = tmp;
                }
                union(map.get(s), map.get(tmp));
            }

        }
        Map<String, Set<String>> res = new HashMap<>();
        for (Map.Entry<String, Node> e : map.entrySet()) {
            Node node = find(map.get(e.getKey()));
            res.putIfAbsent(node.email, new TreeSet<>());
            res.get(node.email).add(e.getKey());
        }
        List<List<String>> result = new ArrayList<>();
        for (Set<String> set : res.values()) {
            List<String> temp = new ArrayList<>(set);
            temp.add(0, map.get(temp.get(0)).name);
            result.add(temp);
        }
        return result;
    }

    class Node {
        Node parent;
        String name;
        String email;

    }

    public void union(Node x, Node y) {
        Node x1 = find(x);
        Node y1 = find(y);
        x1.parent = y1;
    }

    public Node find(Node x) {
        if (x != x.parent) {
            x.parent = find(x.parent);
        }
        return x.parent;
    }

}
