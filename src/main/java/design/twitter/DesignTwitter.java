package design.twitter;

import java.util.*;

/**
 * @author hum
 */
public class DesignTwitter {
    Map<Integer, Set<Integer>> map;
    List<int[]> list;

    public DesignTwitter() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }


    public void postTweet(int userId, int tweetId) {
        int[] tmp = new int[2];
        tmp[0] = userId;
        tmp[1] = tweetId;
        list.add(tmp);
    }


    public List<Integer> getNewsFeed(int userId) {
        int len = list.size() - 1;
        List<Integer> result = new ArrayList<>();
        for (int i = len; result.size() < 10 && i >= 0; i--) {
            int tmpId = list.get(i)[0];
            Set<Integer> set = map.get(userId);
            if (tmpId == userId || (set != null && set.contains(tmpId))) {
                result.add(list.get(i)[1]);
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (map.containsKey(followerId)) {
            map.get(followerId).add(followeeId);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            map.put(followerId, set);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (map.containsKey(followerId)) {
            map.get(followerId).remove(followeeId);
        }
    }
}
