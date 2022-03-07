package cells.in.a.range.on.an.excel.sheet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class CellsInARangeOnAnExcelSheet {
  public List<String> cellsInRange(String s) {
    List<String> res = new ArrayList<>();
    char start = s.charAt(0);
    int n1 = s.charAt(1) - '0';
    char end = s.charAt(3);
    int n2 = s.charAt(4) - '0';
    for (char i = start; i <= end; i++) {
      for (int j = n1; j <= n2; j++) {
        res.add(i + String.valueOf(j));
      }
    }
    return res;
  }
}
