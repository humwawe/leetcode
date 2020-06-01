package invalid.transactions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < transactions.length; i++) {
            for (int j = 0; j < transactions.length; j++) {
                if (i == j) {
                    continue;
                }
                String[] split = transactions[i].split(",");
                String name = split[0];
                String time = split[1];
                String amount = split[2];
                String city = split[3];
                String[] split1 = transactions[j].split(",");
                String name1 = split1[0];
                String time1 = split1[1];
                String city1 = split1[3];
                if (Integer.valueOf(amount) > 1000) {
                    result.add(transactions[i]);
                    break;
                }
                if (name.equals(name1) && !city.equals(city1) && Math.abs(Integer.valueOf(time) - Integer.valueOf(time1)) <= 60) {
                    result.add(transactions[i]);
                    break;
                }
            }
        }

        return result;
    }
}
