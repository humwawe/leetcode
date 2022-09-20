package count.days.spent.together;

/**
 * @author hum
 */
public class CountDaysSpentTogether {
  public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
    String s;
    String t;
    if (arriveAlice.compareTo(arriveBob) >= 0) {
      s = arriveAlice;
    } else {
      s = arriveBob;
    }
    if (leaveAlice.compareTo(leaveBob) >= 0) {
      t = leaveBob;
    } else {
      t = leaveAlice;
    }


    int[] m = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int sm = Integer.parseInt(s.substring(0, 2));
    int sd = Integer.parseInt(s.substring(3));
    int tm = Integer.parseInt(t.substring(0, 2));
    int td = Integer.parseInt(t.substring(3));
    int a = 0;
    int b = 0;
    for (int i = 0; i < sm - 1; i++) {
      a += m[i];
    }
    a += sd;
    for (int i = 0; i < tm - 1; i++) {
      b += m[i];
    }
    b += td;
    return Math.max(0, b - a + 1);

  }
}
