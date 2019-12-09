package shopping.offers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {
    private Map<String, Integer> map = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        List<Integer> t = new ArrayList<>();
        for (Integer need : needs) {
            t.add(0);
        }
        map.put(t.toString(), 0);
        return helper(price, special, needs);
    }

    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (map.containsKey(needs.toString())) {
            return map.get(needs.toString());
        }
        int res = dot(price, needs);
        for (List<Integer> list : special) {
            if (less(list, needs)) {
                if (list.get(list.size() - 1) > res) {
                    continue;
                }
                List<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < needs.size(); i++) {
                    tmp.add(needs.get(i) - list.get(i));
                }
                res = Math.min(res, list.get(list.size() - 1) + helper(price, special, tmp));
            }
        }
        map.put(needs.toString(), res);
        return res;
    }

    private boolean less(List<Integer> list, List<Integer> needs) {
        boolean flag = true;
        for (int i = 0; i < needs.size(); i++) {
            if (list.get(i) > needs.get(i)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private int dot(List<Integer> price, List<Integer> needs) {
        int sum = 0;
        for (int i = 0; i < needs.size(); i++) {
            sum += price.get(i) * needs.get(i);
        }
        return sum;
    }

}
