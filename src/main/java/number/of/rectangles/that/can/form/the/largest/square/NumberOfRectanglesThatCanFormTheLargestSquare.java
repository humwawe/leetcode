package number.of.rectangles.that.can.form.the.largest.square;

/**
 * @author hum
 */
public class NumberOfRectanglesThatCanFormTheLargestSquare {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        for (int[] rectangle : rectangles) {
            max = Math.max(max, Math.min(rectangle[0], rectangle[1]));
        }
        int res = 0;
        for (int[] rectangle : rectangles) {
            if (Math.min(rectangle[0], rectangle[1]) == max) {
                res++;
            }
        }
        return res;
    }
}
