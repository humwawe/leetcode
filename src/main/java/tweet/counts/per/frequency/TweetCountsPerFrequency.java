package tweet.counts.per.frequency;

import java.util.*;

/**
 * @author hum
 */
public class TweetCountsPerFrequency {
    private Map<String, TreeSet<Integer>> map;

    public TweetCountsPerFrequency() {
        map = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        if (!map.containsKey(tweetName)) {
            map.put(tweetName, new TreeSet<>());
        }
        map.get(tweetName).add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        TreeSet<Integer> treeSet = map.get(tweetName);
        List<Integer> list = new ArrayList<>();
        if (freq.equals("minute")) {
            int start = startTime;
            while (start <= endTime) {
                int end = Math.min(endTime, start + 60 - 1);
                list.add(treeSet.subSet(start, true, end, true).size());
                start = end + 1;
            }
        } else if (freq.equals("hour")) {
            int start = startTime;
            while (start <= endTime) {
                int end = Math.min(endTime, start + 3600 - 1);
                list.add(treeSet.subSet(start, true, end, true).size());
                start = end + 1;
            }
        } else {
            int start = startTime;
            while (start <= endTime) {
                int end = Math.min(endTime, start + 3600 * 24 - 1);
                list.add(treeSet.subSet(start, true, end, true).size());
                start = end + 1;
            }
        }
        return list;
    }
}
