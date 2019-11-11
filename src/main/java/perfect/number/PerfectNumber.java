package perfect.number;

public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num < 2) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i * i == num) {
                    sum += i;
                } else {
                    sum += i + num / i;
                }
            }
        }
        return num == sum;
    }
}
