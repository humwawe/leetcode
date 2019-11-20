package reverse.string.II;

public class ReverseStringII {
    public String reverseStr(String s, int k) {
        int count = 0;
        boolean flag = true;
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count < k && flag) {
                result.insert(index, s.charAt(i));
            } else {
                if (count == k) {
                    count = 0;
                    flag = !flag;
                }
                result.append(s.charAt(i));
                index = i;
            }
            count++;
        }
        return result.toString();
    }
}
