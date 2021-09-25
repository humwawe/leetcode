package value.of.variable.after.performing.operations;

/**
 * @author hum
 */
public class FinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if (operation.contains("+")) {
                res++;
            } else {
                res--;
            }
        }
        return res;
    }
}
