package fibonacci.number;

public class FibonacciNumber {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int last = 0;
        int last2 = 1;
        int result = 0;
        for (int i = 1; i < n; i++) {
            result = last + last2;
            last = last2;
            last2 = result;
        }
        return result;
    }
}
