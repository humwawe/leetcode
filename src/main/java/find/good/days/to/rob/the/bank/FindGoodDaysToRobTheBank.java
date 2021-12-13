package find.good.days.to.rob.the.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FindGoodDaysToRobTheBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int len = security.length;
        int[] pre = new int[len];
        for (int i = 1; i < len; i++) {
            if (security[i] <= security[i - 1]) {
                pre[i] = pre[i - 1] + 1;
            } else {
                pre[i] = 0;
            }
        }
        int[] suf = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                suf[i] = suf[i + 1] + 1;
            } else {
                suf[i] = 0;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (Math.min(pre[i], suf[i]) >= time) {
                list.add(i);
            }
        }
        return list;
    }
}
