package number.of.ways.to.buy.pens.and.pencils;

/**
 * @author hum
 */
public class NumberOfWaysToBuyPensAndPencils {
  public long waysToBuyPensPencils(int total, int cost1, int cost2) {
    int lim = total / cost1;
    long res = 0;
    for (int i = 0; i <= lim; i++) {
      int last = total - cost1 * i;
      res += last / cost2 + 1;
    }
    return res;
  }
}
