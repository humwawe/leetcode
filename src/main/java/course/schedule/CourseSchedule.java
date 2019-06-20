package course.schedule;

import java.util.*;

/**
 * @author hum
 */
public class CourseSchedule {
    Map<Integer, Set<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0];
            int y = prerequisite[1];
            if (map.containsKey(x)) {
                map.get(x).add(y);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(y);
                map.put(x, set);
            }

        }
        int[] visited = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0];
            if (!helper(x, visited)) {
                return false;
            }
        }
        return true;

    }

    private boolean helper(int x, int[] visited) {
        if (visited[x] == -1) {
            return false;
        }
        if (visited[x] == 1) {
            return true;
        }
        visited[x] = -1;
        Set<Integer> set = map.getOrDefault(x, new HashSet<>());
        for (Integer num : set) {
            if (!helper(num, visited)) {
                return false;
            }
        }
        visited[x] = 1;
        return true;
    }

}
