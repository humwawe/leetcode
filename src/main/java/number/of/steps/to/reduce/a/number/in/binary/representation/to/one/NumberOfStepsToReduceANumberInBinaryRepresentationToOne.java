package number.of.steps.to.reduce.a.number.in.binary.representation.to.one;

import java.math.BigInteger;

/**
 * @author hum
 */
public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    public int numSteps(String s) {
        BigInteger bigInteger = new BigInteger(s, 2);
        BigInteger target = new BigInteger("1");
        BigInteger div = new BigInteger("2");
        int result = 0;
        while (!bigInteger.equals(target)) {
            if (bigInteger.mod(div).equals(target)) {
                bigInteger = bigInteger.add(target);
            } else {
                bigInteger = bigInteger.divide(div);
            }
            result++;
        }
        return result;
    }
}
