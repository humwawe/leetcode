package zig.zag.conversion;

/**
 * @author hum
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int index = 0;
        //在中间行是否插入
        boolean insertFlag;
        int length = s.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            index = i;
            insertFlag = true;
            while (index < length) {
                result.append(s.charAt(index));
                if (i == 0 || i == numRows - 1) {
                    index += 2 * (numRows - 1);
                } else {
                    index += (insertFlag) ? 2 * (numRows - 1) - 2 * i : 2 * i;
                    insertFlag = !insertFlag;
                }
            }
        }
        return result.toString();
    }
}
