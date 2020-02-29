package lemonade.change;

/**
 * @author hum
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }
            if (bill == 10) {
                if (five == 0) {
                    return false;
                } else {
                    five--;
                    ten++;
                }
            }

            if (bill == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                    twenty++;
                } else if (ten == 0 && five >= 3) {
                    five -= 3;
                    twenty++;
                } else {
                    return false;
                }

            }
        }
        return true;
    }
}
