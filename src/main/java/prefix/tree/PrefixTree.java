package prefix.tree;

/**
 * @author hum
 */
class TrieNode {
    TrieNode[] child;
    boolean is_end;

    public TrieNode() {
        child = new TrieNode[26];
        is_end = false;
    }
}

public class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode ptr = root;
        for (char c : word.toCharArray()) {
            if (ptr.child[c - 'a'] == null) {
                ptr.child[c - 'a'] = new TrieNode();
            }
            ptr = ptr.child[c - 'a'];
        }
        ptr.is_end = true;
    }


    public boolean search(String word) {
        TrieNode ptr = root;
        for (char c : word.toCharArray()) {
            if (ptr.child[c - 'a'] == null) {
                return false;
            }
            ptr = ptr.child[c - 'a'];
        }
        return ptr.is_end;
    }

    public boolean startsWith(String prefix) {
        TrieNode ptr = root;
        for (char c : prefix.toCharArray()) {
            if (ptr.child[c - 'a'] == null) {
                return false;
            }
            ptr = ptr.child[c - 'a'];
        }
        return true;
    }
}
