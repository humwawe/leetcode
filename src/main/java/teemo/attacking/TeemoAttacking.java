package teemo.attacking;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        if (len == 0) {
            return 0;
        }
        int start = timeSeries[0];
        int end = start + duration;
        int result = 0;
        for (int i = 1; i < len; i++) {
            if (timeSeries[i] <= end) {
                end = timeSeries[i] + duration;
            } else {
                result += end - start;
                start = timeSeries[i];
                end = start + duration;
            }
        }
        return result + end - start;
    }
}
