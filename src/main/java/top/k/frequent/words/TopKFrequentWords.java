package top.k.frequent.words;

import java.util.*;

/**
 * @author hum
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(entry);
            } else {
                if (entry.getValue() >= priorityQueue.peek().getValue()) {
                    priorityQueue.add(entry);
                    priorityQueue.poll();
                }
            }
        }
        while (!priorityQueue.isEmpty()) {
            result.add(0, priorityQueue.poll().getKey());
        }
        return result;
    }
}
