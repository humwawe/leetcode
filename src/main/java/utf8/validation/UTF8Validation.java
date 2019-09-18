package utf8.validation;

/**
 * @author hum
 */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        int index = 0;
        while (index < data.length) {
            int tmp = data[index];
            if ((tmp & 0b10000000) == 0) {
                index++;
            } else if ((tmp & 0b11100000) == 0b11000000) {
                for (int i = 1; i <= 1; i++) {
                    if (!helper(data, index + i)) {
                        return false;
                    }
                }
                index += 2;
            } else if ((tmp & 0b11110000) == 0b11100000) {
                for (int i = 1; i <= 2; i++) {
                    if (!helper(data, index + i)) {
                        return false;
                    }
                }
                index += 3;
            } else if ((tmp & 0b11111000) == 0b11110000) {
                for (int i = 1; i <= 3; i++) {
                    if (!helper(data, index + i)) {
                        return false;
                    }
                }
                index += 4;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean helper(int[] data, int index) {
        if (index > data.length) {
            return false;
        }
        return (data[index] & 0b10000000) == 0b10000000;
    }
}
