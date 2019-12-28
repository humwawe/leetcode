package design.hash.set;

/**
 * @author hum
 */
public class DesignHashSet {
    boolean[] map = new boolean[1000005];

    public DesignHashSet() {

    }

    public void add(int key) {
        map[key] = true;
    }

    public void remove(int key) {
        map[key] = false;
    }

    public boolean contains(int key) {
        return map[key];
    }
}
