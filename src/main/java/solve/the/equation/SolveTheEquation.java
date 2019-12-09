package solve.the.equation;

/**
 * @author hum
 */
public class SolveTheEquation {
    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        String left = helper(split[0]);
        String right = helper(split[1]);
        String[] s1 = left.split("\\+");
        String[] s2 = right.split("\\+");
        int lx = 0, ln = 0;
        int rx = 0, rn = 0;
        for (String a : s1) {
            if ("".equals(a)) {
                continue;
            }
            if (a.endsWith("x")) {
                if (a.length() == 1) {
                    lx += 1;
                } else if ("-x".equals(a)) {
                    lx += -1;
                } else {
                    lx += Integer.valueOf(a.substring(0, a.length() - 1));
                }

            } else {
                ln += Integer.valueOf(a);
            }
        }
        for (String a : s2) {
            if (a.endsWith("x")) {
                if (a.length() == 1) {
                    rx += 1;
                } else if ("-x".equals(a)) {
                    rx += -1;
                } else {
                    rx += Integer.valueOf(a.substring(0, a.length() - 1));
                }
            } else if (!"".equals(a)) {
                rn += Integer.valueOf(a);
            }
        }
        int x = lx - rx;
        int n = rn - ln;
        if (x == 0 && n == 0) {
            return "Infinite solutions";
        }
        if (x == 0) {
            return "No solution";
        }
        return "x=" + n / x;
    }

    private String helper(String right) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < right.length(); i++) {
            char c = right.charAt(i);
            if (c == '-') {
                tmp.append('+');
            }
            tmp.append(c);
        }
        return tmp.toString();
    }
}
