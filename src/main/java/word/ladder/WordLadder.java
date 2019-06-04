package word.ladder;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @author hum
 */
public class WordLadder {
    private int result = 1;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        return helper(beginWord, endWord, wordList);

    }

    private int helper(String beginWord, String endWord, List<String> wordList) {
        int len = wordList.size();
        boolean[] visit = new boolean[len];
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String tmp = queue.poll();
                for (int i = 0; i < len; i++) {
                    String word = wordList.get(i);
                    if (canMove(tmp, word) && !visit[i]) {
                        if (word.equals(endWord)) {
                            return ++result;
                        }
                        visit[i] = true;
                        queue.add(word);
                    }
                }
            }
            result++;
        }
        return 0;
    }

    private boolean canMove(String beginWord, String word) {
        if (beginWord.length() != word.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i) != word.charAt(i)) {
                count++;
            }
            if (count > 2) {
                break;
            }
        }
        return count == 1;
    }
}
