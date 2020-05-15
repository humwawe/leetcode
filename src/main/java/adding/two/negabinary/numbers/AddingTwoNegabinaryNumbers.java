package adding.two.negabinary.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class AddingTwoNegabinaryNumbers {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int carry = 0;
        int a = 0;
        int b = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i < 0) {
                a = 0;
            } else {
                a = arr1[i];
            }
            if (j < 0) {
                b = 0;
            } else {
                b = arr2[j];
            }
            int t = (a + b + carry) % -2;
            carry = (a + b + carry) / -2;
            if (t < 0) {
                carry++;
            }
            list.add(0, Math.abs(t));
            i--;
            j--;
        }

        while (list.size() > 0) {
            if (list.get(0) == 0) {
                list.remove(0);
            } else {
                break;
            }
        }
        if (list.isEmpty()) {
            return new int[]{0};
        }
        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);

        }
        return result;
    }
}
