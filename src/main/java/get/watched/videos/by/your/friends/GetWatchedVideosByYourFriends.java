package get.watched.videos.by.your.friends;

import java.util.*;

/**
 * @author hum
 */
public class GetWatchedVideosByYourFriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[105];
        queue.add(id);
        vis[id] = true;
        while (!queue.isEmpty() && level-- > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int j : friends[poll]) {
                    if (vis[j]) {
                        continue;
                    }
                    queue.add(j);
                    vis[j] = true;
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<String> list = watchedVideos.get(poll);
            for (String s : list) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }

        }
        System.out.println(map);
        List<R> res = new ArrayList<>();
        for (String s : map.keySet()) {
            res.add(new R(s, map.get(s)));
        }

        res.sort((a, b) -> a.c == b.c ? a.s.compareTo(b.s) : a.c - b.c);
        List<String> result = new ArrayList<>();
        for (R re : res) {
            result.add(re.s);
        }
        return result;
    }

    class R {
        String s;
        int c;

        public R(String s, int c) {
            this.s = s;
            this.c = c;
        }
    }
}
