package find.the.closest.palindrome;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindTheClosestPalindrome {
    public String nearestPalindromic(String n) {
        int len = n.length();
        if (len == 1) {
            return String.valueOf(Integer.parseInt(n) - 1);
        }
        long longN = Long.parseLong(n);
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < len - 1; i++) {
            stringBuilder1.append("9");
        }
        long dif1 = Math.abs(Long.parseLong(stringBuilder1.toString()) - longN);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("11");
        for (int i = 0; i < len - 1; i++) {
            stringBuilder2.insert(1, "0");
        }
        long dif2 = Math.abs(Long.parseLong(stringBuilder2.toString()) - longN);
        int x = 0;
        int y = len - 1;
        StringBuilder stringBuilder3 = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder3.append("9");
        }
        while (x <= y) {
            for (int i = 8; i >= 0; i--) {
                stringBuilder3.setCharAt(x, (char) (i + '0'));
                stringBuilder3.setCharAt(y, (char) (i + '0'));
                if (stringBuilder3.toString().compareTo(n) <= 0) {
                    stringBuilder3.setCharAt(x, (char) (i + 1 + '0'));
                    stringBuilder3.setCharAt(y, (char) (i + 1 + '0'));
                    break;
                }
            }
            x++;
            y--;
        }
        long dif3 = Math.abs(Long.parseLong(stringBuilder3.toString()) - longN);
        StringBuilder stringBuilder4 = new StringBuilder();
        x = 0;
        y = len - 1;
        for (int i = 0; i < len; i++) {
            stringBuilder4.append("0");
        }
        while (x <= y) {
            for (int i = 1; i <= 9; i++) {
                stringBuilder4.setCharAt(x, (char) (i + '0'));
                stringBuilder4.setCharAt(y, (char) (i + '0'));
                if (stringBuilder4.toString().compareTo(n) >= 0) {
                    stringBuilder4.setCharAt(x, (char) (i - 1 + '0'));
                    stringBuilder4.setCharAt(y, (char) (i - 1 + '0'));
                    break;
                }
            }
            x++;
            y--;
        }
        long dif4 = Math.abs(Long.parseLong(stringBuilder4.toString(), 10) - longN);

        TreeMap<Long, String> map = new TreeMap<>();
        if (dif3 != 0) {
            map.put(dif3, stringBuilder3.toString());
        }
        if (dif2 != 0) {
            map.put(dif2, stringBuilder2.toString());
        }
        if (dif4 != 0) {
            map.put(dif4, stringBuilder4.toString());
        }
        if (dif1 != 0) {
            map.put(dif1, stringBuilder1.toString());
        }
        return map.get(map.firstKey());
    }

    public static void main(String[] args) {
        FindTheClosestPalindrome findTheClosestPalindrome = new FindTheClosestPalindrome();
        System.out.println(findTheClosestPalindrome.nearestPalindromic("888888888888888888"));
    }
}
