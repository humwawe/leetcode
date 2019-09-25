package evaluate.division;

import java.util.*;

/**
 * @author hum
 */
public class EvaluateDivision {
    Map<String, List<String>> map = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            String divisor = equations.get(i).get(0);
            String dividend = equations.get(i).get(1);
            double value = values[i];
            List<String> divisorR = map.getOrDefault(divisor, new ArrayList<>());
            divisorR.add(value + "_" + dividend);
            map.put(divisor, divisorR);
            List<String> dividendR = map.getOrDefault(dividend, new ArrayList<>());
            dividendR.add(1 / value + "_" + divisor);
            map.put(dividend, dividendR);
        }
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String divisor = query.get(0);
            String dividend = query.get(1);
            List<String> divisorR = map.get(divisor);
            List<String> dividendR = map.get(dividend);
            if (divisorR == null || dividendR == null) {
                result[i] = -1.0;
                continue;
            }
            if (divisor.equals(dividend)) {
                result[i] = 1.0;
                continue;
            }
            Set<String> visit = new HashSet<>();
            visit.add(divisor);
            Double dfs = helper(divisorR, visit, dividend);
            result[i] = dfs == null ? -1.0 : dfs;
        }
        return result;
    }

    private Double helper(List<String> divisorR, Set<String> visit, String dividend) {
        for (String s : divisorR) {
            String[] split = s.split("_");
            double res = Double.valueOf(split[0]);
            if (!visit.contains(split[1])) {
                if (split[1].equals(dividend)) {
                    return res;
                }
                visit.add(split[1]);
                Double next = helper(map.get(split[1]), visit, dividend);
                if (next != null) {
                    return res * next;
                }
                visit.remove(split[1]);
            }
        }
        return null;
    }
}
