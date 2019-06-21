package prefix.tree;

/**
 * @author hum
 */
class TrieNode {
    TrieNode[] child;
    boolean isEnd;

    public TrieNode() {
        child = new TrieNode[26];
        isEnd = false;
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
        ptr.isEnd = true;
    }


    public boolean search(String word) {
        TrieNode ptr = root;
        for (char c : word.toCharArray()) {
            if (ptr.child[c - 'a'] == null) {
                return false;
            }
            ptr = ptr.child[c - 'a'];
        }
        return ptr.isEnd;
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
