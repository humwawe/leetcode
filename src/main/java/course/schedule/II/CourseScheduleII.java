package course.schedule.II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author hum
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        boolean[] visit = new boolean[numCourses];
        List<Integer> result = new ArrayList<>();
        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                result.add(i);
                visit[i] = true;
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer front = queue.poll();
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == front) {
                    degree[prerequisite[0]]--;
                    if (degree[prerequisite[0]] == 0 && !visit[prerequisite[0]]) {
                        result.add(prerequisite[0]);
                        queue.add(prerequisite[0]);
                        visit[prerequisite[0]] = true;
                    }
                }

            }
        }
        if (result.size() == numCourses) {
            return result.stream().mapToInt(i -> i).toArray();
        }
        return new int[0];
    }
}
