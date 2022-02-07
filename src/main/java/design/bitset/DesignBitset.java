package design.bitset;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class DesignBitset {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> set2 = new HashSet<>();
    int size;
    boolean f = false;

    public DesignBitset(int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            set2.add(i);
        }
    }

    public void fix(int idx) {
        set1.add(idx);
        set2.remove(idx);
    }

    public void unfix(int idx) {
        set1.remove(idx);
        set2.add(idx);
    }

    public void flip() {
        Set<Integer> tmp = set1;
        set1 = set2;
        set2 = tmp;
    }

    public boolean all() {
        return set1.size() == size;
    }

    public boolean one() {
        return set1.size() > 0;
    }

    public int count() {
        return set1.size();
    }

    public String toStr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (set1.contains(i)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        return sb.toString();
    }
}
