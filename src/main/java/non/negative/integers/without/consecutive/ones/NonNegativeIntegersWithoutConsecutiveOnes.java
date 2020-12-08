package non.negative.integers.without.consecutive.ones;

public class NonNegativeIntegersWithoutConsecutiveOnes {
    private int[][] memo;

    public int findIntegers(int num) {
        String s = Integer.toBinaryString(num);
        int len = s.length();
        memo = new int[len][2];
        System.out.println(s);
        int result = 0;
        boolean prev = false;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                result += helper(len - 1 - i, 0);
                if (prev) {
                    return result;
                }
                prev = true;
            } else {
                prev = false;
            }
        }
        return result + 1;
    }

    private int helper(int i, int prev) {
        if (i == 0) {
            return 1;
        }
        if (memo[i][prev] != 0) {
            return memo[i][prev];
        }
        if (prev == 1) {
            return memo[i][prev] = helper(i - 1, 0);
        } else {
            return memo[i][prev] = helper(i - 1, 1) + helper(i - 1, 0);
        }
    }

}
