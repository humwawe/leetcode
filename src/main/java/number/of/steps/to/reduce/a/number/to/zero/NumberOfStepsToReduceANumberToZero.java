package number.of.steps.to.reduce.a.number.to.zero;

/**
 * @author hum
 */
public class NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps(int num) {
        int result = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            result++;
        }
        return result;
    }
}
