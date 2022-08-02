package maximum.number.of.groups.entering.a.competition;

/**
 * @author hum
 */
public class MaximumNumberOfGroupsEnteringACompetition {
  public int maximumGroups(int[] grades) {
    long len = grades.length;
    int res = 1;
    while ((long) (res + 2) * (res + 1) / 2 <= len) {
      res++;
    }
    return res;
  }
}
