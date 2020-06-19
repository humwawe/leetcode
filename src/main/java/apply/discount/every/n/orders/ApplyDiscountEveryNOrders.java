package apply.discount.every.n.orders;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class ApplyDiscountEveryNOrders {
    int n, discount, cnt;
    Map<Integer, Integer> menu = new HashMap<>();

    public ApplyDiscountEveryNOrders(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        for (int i = 0; i < products.length; i++) {
            menu.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        cnt++;
        double res = 0;
        for (int i = 0; i < product.length; i++) {
            res += menu.get(product[i]) * amount[i];
        }
        if (cnt % n == 0) {
            res = res - (discount * res) / 100;
        }
        return res;
    }
}
