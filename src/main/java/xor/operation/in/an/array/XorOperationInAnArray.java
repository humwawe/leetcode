package xor.operation.in.an.array;

/**
 * @author hum
 */
public class XorOperationInAnArray {
    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= (2 * i + start);
        }
        return result;
    }
}
