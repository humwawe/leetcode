package integer.to.english.words;

/**
 * @author hum
 */
public class IntegerToEnglishWords {
    private final String[] less20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] less100 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] more100 = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        String res = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + more100[i] + " " + res;
            }
            num = num / 1000;
            i++;
        }
        return res.trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return less20[num] + " ";
        } else if (num < 100) {
            return less100[num / 10] + " " + helper(num % 10);
        } else {
            return less20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
