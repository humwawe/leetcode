package construct.the.rectangle;

/**
 * @author hum
 */
public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        for (int i = (int) Math.ceil(Math.sqrt(area)); i <= area; i++) {
            if (area % i == 0) {
                result[0] = i;
                result[1] = area / i;
                return result;
            }
        }
        return result;
    }
}
