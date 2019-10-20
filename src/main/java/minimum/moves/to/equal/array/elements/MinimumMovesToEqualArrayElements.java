package minimum.moves.to.equal.array.elements;

/**
 * @author hum
 */
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int result = 0;
        for (int num : nums) {
            result += num - min;
        }
        return result;
    }
}
