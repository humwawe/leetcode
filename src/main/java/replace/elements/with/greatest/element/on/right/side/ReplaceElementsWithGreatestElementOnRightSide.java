package replace.elements.with.greatest.element.on.right.side;

/**
 * @author hum
 */
public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        result[len - 1] = -1;
        int max = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            result[i] = max;
            max = Math.max(max, arr[i]);
        }
        return result;
    }
}
