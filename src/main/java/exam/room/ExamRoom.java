package exam.room;

import java.util.TreeSet;

/**
 * @author hum
 */
public class ExamRoom {
    int n;
    TreeSet<Integer> set;

    public ExamRoom(int n) {
        this.n = n;
        set = new TreeSet<>();
    }

    public int seat() {
        int res = 0;
        if (set.size() > 0) {
            int dist = set.first();
            Integer prev = null;
            for (Integer s : set) {
                if (prev != null) {
                    int d = (s - prev) / 2;
                    if (d > dist) {
                        dist = d;
                        res = prev + d;
                    }
                }
                prev = s;
            }
            if (n - 1 - set.last() > dist) {
                res = n - 1;
            }
        }
        set.add(res);
        return res;

    }

    public void leave(int p) {
        set.remove(p);
    }
}
