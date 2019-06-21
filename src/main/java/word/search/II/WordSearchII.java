package word.search.II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hum
 */
public class WordSearchII {
    Set<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {

        PrefixTree prefixTree = new PrefixTree();
        for (String word : words) {
            prefixTree.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(board, i, j, "", used, prefixTree);
            }
        }
        return new ArrayList<>(result);
    }

    private void helper(char[][] board, int i, int j, String word, boolean[][] used, PrefixTree prefixTree) {
        if ((i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j])) {
            return;
        }
        word += board[i][j];
        if (!prefixTree.startsWith(word)) {
            return;
        }
        if (prefixTree.search(word)) {
            result.add(word);
        }
        used[i][j] = true;
        helper(board, i, j - 1, word, used, prefixTree);
        helper(board, i, j + 1, word, used, prefixTree);
        helper(board, i - 1, j, word, used, prefixTree);
        helper(board, i + 1, j, word, used, prefixTree);
        used[i][j] = false;
    }
}

class TrieNode {
    TrieNode[] child;
    boolean isEnd;

    public TrieNode() {
        child = new TrieNode[26];
        isEnd = false;
    }
}

class PrefixTree {
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

