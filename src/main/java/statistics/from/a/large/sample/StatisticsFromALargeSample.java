package statistics.from.a.large.sample;

/**
 * @author hum
 */
public class StatisticsFromALargeSample {
    public double[] sampleStats(int[] count) {
        double[] result = new double[5];
        double min = 0;
        double max = 0;
        double m = 0;
        boolean f = false;
        double sum = 0;
        int c = 0;
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                if (!f) {
                    min = i;
                    f = true;
                }
                max = Math.max(max, i);
                m = Math.max(m, count[i]);
                sum += i * count[i];
                c += count[i];
            }
        }
        result[0] = min;
        result[1] = max;
        result[2] = sum / c;
        int a = -1;
        int b = -1;
        int s = 0;
        for (int i = 0; i < 256; i++) {
            s += count[i];
            if (count[i] == m) {
                result[4] = i;
            }
            if (a == -1 && s >= c / 2) {
                a = i;
            }
            if (b == -1 && s >= c / 2 + 1) {
                b = i;
            }
        }
        if (c % 2 == 0) {
            result[3] = (a + b) / 2.0;
        } else {
            result[3] = b;
        }
        return result;
    }
}
