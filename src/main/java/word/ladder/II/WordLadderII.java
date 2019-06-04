package word.ladder.II;

import java.util.*;

/**
 * @author hum
 */
public class WordLadderII {

    private List<List<String>> results = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }
        helper(beginWord, endWord, wordList);
        return results;
    }

    private void helper(String beginWord, String endWord, List<String> wordList) {
        int len = wordList.size();
        boolean[] visit = new boolean[len];
        Map<String, List<String>> parent = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<Integer> set = new HashSet<>();
            while (size-- > 0) {
                String tmp = queue.poll();
                for (int i = 0; i < len; i++) {
                    String word = wordList.get(i);
                    if (canMove(tmp, word) && !visit[i]) {
                        set.add(i);
                        if (!parent.containsKey(word)) {
                            List<String> p = new ArrayList<>();
                            p.add(tmp);
                            parent.put(word, p);
                        } else {
                            parent.get(word).add(tmp);
                        }
                    }
                }
            }
            for (Integer i : set) {
                visit[i] = true;
                queue.add(wordList.get(i));
            }
            if (parent.containsKey(endWord)) {
                generateResult(parent, endWord, beginWord, new ArrayList<>());
                break;
            }
        }
    }

    public void generateResult(Map<String, List<String>> parent, String endWord, String beginWord, List<String> result) {
        if (endWord.equals(beginWord)) {
            result.add(0, endWord);
            results.add(new ArrayList<>(result));
            result.remove(0);
            return;
        }

        result.add(0, endWord);
        List<String> words = parent.get(endWord);
        for (int i = 0; i < words.size(); i++) {
            generateResult(parent, words.get(i), beginWord, result);
        }
        result.remove(0);
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
