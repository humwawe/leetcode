package the.skyline.problem;

import java.util.*;

/**
 * @author hum
 */
public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Nod> nods = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>((a1, a2) -> a2 - a1);
        List<List<Integer>> results = new ArrayList<>();

        for (int[] b : buildings) {
            nods.add(new Nod(b[0], true, b[2]));
            nods.add(new Nod(b[1], false, b[2]));
        }
        nods.sort(Comparator.comparingInt(a -> a.x));

        int index = 0;
        int prevHeight = 0;
        while (index < nods.size()) {
            int curX = nods.get(index).x;
            while (index < nods.size() && curX == nods.get(index).x) {
                Nod nod = nods.get(index);
                if (nod.start) {
                    queue.offer(nod.h);
                } else {
                    queue.remove(nod.h);
                }
                index++;
            }
            Integer curMaxheight = queue.peek();
            if (curMaxheight == null) {
                curMaxheight = 0;
            }
            if (curMaxheight != prevHeight) {
                prevHeight = curMaxheight;
                List<Integer> result = new ArrayList<>();
                result.add(curX);
                result.add(curMaxheight);
                results.add(result);
            }

        }
        return results;
    }
}

class Nod {
    int x;
    boolean start;
    Integer h;

    Nod(int x, boolean start, Integer h) {
        this.x = x;
        this.start = start;
        this.h = h;
    }
}