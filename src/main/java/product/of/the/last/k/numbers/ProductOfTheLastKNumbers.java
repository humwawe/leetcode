package product.of.the.last.k.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class ProductOfTheLastKNumbers {
    private List<Integer> products;

    public ProductOfTheLastKNumbers() {
        products = new ArrayList<>();
        products.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            products = new ArrayList<>();
            products.add(1);
        } else {
            products.add(products.get(products.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        if (products.size() <= k) {
            return 0;
        }
        return products.get(products.size() - 1) / products.get(products.size() - 1 - k);
    }

}
