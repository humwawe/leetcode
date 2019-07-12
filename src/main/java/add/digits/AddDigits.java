package add.digits;

/**
 * @author hum
 */
public class AddDigits {
    public int addDigits(int num) {
        while (num >= 10) {
            int tmpSum = 0;
            while (num > 0) {
                tmpSum += num % 10;
                num /= 10;
            }
            num = tmpSum;
        }
        return num;
    }
}
