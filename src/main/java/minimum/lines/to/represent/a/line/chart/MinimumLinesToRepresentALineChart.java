package minimum.lines.to.represent.a.line.chart;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class MinimumLinesToRepresentALineChart {
  public int minimumLines(int[][] stockPrices) {
    int len = stockPrices.length;
    Arrays.sort(stockPrices, Comparator.comparingInt(x -> x[0]));

    int res = 0;
    for (int i = 0; i < len - 1; i++) {
      if (i == 0) {
        res++;
        continue;
      }
      long x0 = stockPrices[i - 1][0];
      long y0 = stockPrices[i - 1][1];
      long x1 = stockPrices[i][0];
      long y1 = stockPrices[i][1];
      long x2 = stockPrices[i + 1][0];
      long y2 = stockPrices[i + 1][1];
      if ((y2 - y1) * (x1 - x0) != (y1 - y0) * (x2 - x1)) {
        res++;
      }

    }
    return res;
  }
}
