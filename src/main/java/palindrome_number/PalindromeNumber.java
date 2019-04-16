package palindrome_number;

/**
 * @author hum
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int length = 0;
        int temp = x;
        while (temp != 0) {
            temp = temp / 10;
            length++;
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (numberAtIndex(x, left) != numberAtIndex(x, right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 返回x在index下标处的值
    private int numberAtIndex(int x, int index) {
        // 假设数字合理
        while (index-- != 0) {
            x = x / 10;
        }
        return x % 10;
    }
}
