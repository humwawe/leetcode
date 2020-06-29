package average.salary.excluding.the.minimum.and.maximum.salary;

import java.util.Arrays;

/**
 * @author hum
 */
public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int len = salary.length;
        double sum = 0;
        for (int i = 1; i < len - 1; i++) {
            sum += salary[i];
        }
        return sum / (len - 2);
    }
}
