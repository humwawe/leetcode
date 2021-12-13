package sequentially.ordinal.rank.tracker;

import java.util.Queue;
import java.util.TreeSet;

/**
 * @author hum
 */
public class SequentiallyOrdinalRankTracker {

    TreeSet<Scenic> treeSet = new TreeSet<>();
    Scenic cur;

    public SequentiallyOrdinalRankTracker() {
        cur = new Scenic("", 0);
        treeSet.add(cur);
    }

    public void add(String name, int score) {
        Scenic tmp = new Scenic(name, score);
        treeSet.add(tmp);
        if (tmp.compareTo(cur) < 0) {
            cur = treeSet.lower(cur);
        }
    }

    public String get() {
        String name = cur.name;
        cur = treeSet.higher(cur);
        return name;
    }

    class Scenic implements Comparable<Scenic> {
        String name;
        int score;

        public Scenic(String name, int score) {
            this.name = name;
            this.score = score;
        }


        @Override
        public int compareTo(Scenic o) {
            if (score != o.score) {
                return o.score - score;
            }
            return name.compareTo(o.name);
        }
    }

}
