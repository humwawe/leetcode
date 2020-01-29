package rabbits.in.forest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int answer : answers) {
            if (answer == 0) {
                result++;
            } else if (!map.containsKey(answer)) {
                map.put(answer, answer);
                result += answer + 1;
            } else {
                map.put(answer, map.get(answer) - 1);
                if (map.get(answer) == 0) {
                    map.remove(answer);
                }
            }
        }
        return result;
    }
}
