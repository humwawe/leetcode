package boats.to.save.people;

import java.util.Arrays;

/**
 * @author hum
 */
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length;
        return helper(people, 0, len - 1, limit);
    }

    private int helper(int[] people, int i, int j, int limit) {
        if (i == j) {
            return 1;
        }
        if (i > j) {
            return 0;
        }
        if (people[i] + people[j] <= limit) {
            return helper(people, i + 1, j - 1, limit) + 1;
        } else {
            return helper(people, i, j - 1, limit) + 1;
        }
    }
}
