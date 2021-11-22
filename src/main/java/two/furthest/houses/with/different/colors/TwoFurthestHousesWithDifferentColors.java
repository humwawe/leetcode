package two.furthest.houses.with.different.colors;

/**
 * @author hum
 */
public class TwoFurthestHousesWithDifferentColors {
    public int maxDistance(int[] colors) {
        int len = colors.length;
        if (colors[0] != colors[len - 1]) {
            return len - 1;
        }
        int left = 1;
        while (colors[left] == colors[0]) {
            left += 1;
        }
        int right = len - 2;
        while (colors[right] == colors[len - 1]) {
            right -= 1;
        }
        return Math.max(right, len - 1 - left);
    }

}
