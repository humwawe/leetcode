package maximum.number.of.weeks.which.you.can.work;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumNumberOfWeeksForWhichYouCanWork {
    public long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);
        long sum = 0;
        for (int milestone : milestones) {
            sum += milestone;
        }
        long max = milestones[milestones.length - 1];
        long last = sum - max;
        if (max <= last + 1) {
            return sum;
        } else {
            return 2 * last + 1;
        }
    }
}
