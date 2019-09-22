package rotate.function;

/**
 * @author hum
 */
public class RotateFunction {
    public int maxRotateFunction(int[] a) {
        int result = 0;
        int sum = 0;
        for (int i1 = 0; i1 < a.length; i1++) {
            int i = a[i1];
            sum += i;
            result += i1 * i;
        }
        int last = result;
        for (int i = 1; i < a.length; i++) {
            int tmp = last + sum - a.length * a[a.length - i];
            result = Math.max(result, tmp);
            last = tmp;
        }
        return result;
    }
}
