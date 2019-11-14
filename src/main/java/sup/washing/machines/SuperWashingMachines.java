package sup.washing.machines;

/**
 * @author hum
 */
public class SuperWashingMachines {
    public int findMinMoves(int[] machines) {
        int len = machines.length, dressTotal = 0;
        for (int m : machines) {
            dressTotal += m;
        }
        if (dressTotal % len != 0) {
            return -1;
        }

        int dressPerMachine = dressTotal / len;
        for (int i = 0; i < len; i++) {
            machines[i] -= dressPerMachine;
        }

        int currSum = 0, maxSum = 0, tmpRes = 0, res = 0;
        for (int m : machines) {
            currSum += m;
            maxSum = Math.max(maxSum, Math.abs(currSum));
            tmpRes = Math.max(maxSum, m);
            res = Math.max(res, tmpRes);
        }
        return res;
    }
}
