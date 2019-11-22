package remove.boxes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class RemoveBoxes {

    private Map<String, Integer> map = new HashMap<>();

    public int removeBoxes(int[] boxes) {
        List<Integer> list = new ArrayList<>();
        for (int box : boxes) {
            list.add(box);
        }
        return helper(list);
    }

    public int removeBox(String input) {
        int profit = 0;
        //System.out.println(input);
        if (input == null || input.length() == 0) {
            return 0;
        }
        if (map.containsKey(input))
            return map.get(input);
        if (input.length() == 1) {
            return 1;
        }
        int start_index = 0;
        int end_index = 0;
        while (start_index < input.length()) {
            char c = input.charAt(start_index);
            int count = 0;
            while (end_index < input.length() && c == input.charAt(end_index)) {
                end_index++;
                count++;
            }
            //now we have choice to select that chunk or not
            if (end_index >= input.length()) {
                profit = Math.max(profit, count * count);
            } else {
                profit = Math.max(profit, removeBox(input.substring(0, start_index) + input.substring(end_index, input.length())) + count * count);
            }
            start_index = end_index;
        }
        map.put(input, profit);
        return profit;
    }

    public int helper(List<Integer> input) {
        int result = 0;
        if (input == null || input.size() == 0) {
            return 0;
        }
        if (map.containsKey(input.toString()))
            return map.get(input.toString());
        if (input.size() == 1) {
            return 1;
        }
        int start_index = 0;
        int end_index = 0;
        while (start_index < input.size()) {
            int c = input.get(start_index);
            int count = 0;
            while (end_index < input.size() && c == input.get(end_index)) {
                end_index++;
                count++;
            }
            if (end_index >= input.size()) {
                result = Math.max(result, count * count);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.addAll(input.subList(0, start_index));
                tmp.addAll(input.subList(end_index, input.size()));
                result = Math.max(result, helper(tmp) + count * count);
            }
            start_index = end_index;
        }
        map.put(input.toString(), result);
        return result;
    }


    public static void main(String[] args) {
        int[] boxs = new int[]{3, 8, 8, 5, 5, 3, 9, 2, 4, 4, 6, 5, 8, 4, 8, 6, 9, 6, 2, 8, 6, 4, 1, 9, 5};
        String box = "3,8,8,5,5,3,9,2,4,4,6,5,4,8,6,9,6,2,8,6,4,1,9,5";
        RemoveBoxes removeBoxes = new RemoveBoxes();
//        System.out.println(removeBoxes.removeBoxes(boxs));
        System.out.println("---------");
        System.out.println(removeBoxes.removeBox(box));
    }
}
