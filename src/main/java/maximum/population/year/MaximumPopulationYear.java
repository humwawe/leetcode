package maximum.population.year;

/**
 * @author hum
 */
public class MaximumPopulationYear {
    public int maximumPopulation(int[][] logs) {
        int res = 0;
        int t = 0;
        for (int i = 1950; i <= 2050; i++) {
            int tmp = 0;
            for (int[] log : logs) {
                if (log[0] <= i && log[1] > i) {
                    tmp++;
                }
            }
            if (tmp > t) {
                res = i;
            }
            t = Math.max(t, tmp);
        }
        return res;
    }
}
