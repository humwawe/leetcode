package excel.sheet.column.title;

/**
 * @author hum
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            int first = n % 26;
            n = n / 26;
            result.insert(0, (char) (first + 'A'));
        }
        return result.toString();
    }
}
