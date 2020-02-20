package find.and.replace.in.string;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class FindAndReplaceInString {
    public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        int len = indexes.length;
        PriorityQueue<Point> points = new PriorityQueue<>(Comparator.comparingInt(a -> a.i));
        for (int i = 0; i < len; i++) {
            points.add(new Point(indexes[i], sources[i], targets[i]));
        }
        int prev = 0;
        StringBuilder result = new StringBuilder();
        while (!points.isEmpty()) {
            Point poll = points.poll();
            int sourLen = poll.s.length();
            String tmp = s.substring(poll.i, poll.i + sourLen);
            if (tmp.equals(poll.s)) {
                result.append(s, prev, poll.i);
                result.append(poll.t);
                prev = poll.i + sourLen;
            }
        }
        result.append(s, prev, s.length());
        return result.toString();
    }

    class Point {
        int i;
        String s;
        String t;

        public Point(int i, String s, String t) {
            this.i = i;
            this.s = s;
            this.t = t;
        }
    }
}
