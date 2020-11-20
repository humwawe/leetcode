package design.an.ordered.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class DesignAnOrderedStream {
    int ptr;
    int n;
    String[] list;

    public DesignAnOrderedStream(int n) {
        ptr = 1;
        this.n = n;
        list = new String[n + 1];
    }

    public List<String> insert(int id, String value) {
        list[id] = value;
        List<String> res = new ArrayList<>();
        if (id == ptr) {
            int i = id;
            for (; i <= n; i++) {
                if (list[i] != null) {
                    res.add(list[i]);
                } else {
                    break;
                }
            }
            ptr = i;
        }
        return res;
    }
}
