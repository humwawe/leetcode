package satisfiability.of.equality.equations;


/**
 * @author hum
 */
public class SatisfiabilityOfEqualityEquations {
    int[] p = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            p[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                p[find(p[equation.charAt(0) - 'a'])] = find(p[equation.charAt(3) - 'a']);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (find(equation.charAt(0) - 'a') == find(equation.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
