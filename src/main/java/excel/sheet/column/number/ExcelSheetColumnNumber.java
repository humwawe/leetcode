package excel.sheet.column.number;

/**
 * @author hum
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;
        int size = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char tmp = s.charAt(i);
            result += (tmp - 'A' + 1) * size;
            size *= 26;
        }
        return result;
    }
}
