package time.needed.to.buy.tickets;

/**
 * @author hum
 */
public class TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int len = tickets.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (i <= k) {
                res += Math.min(tickets[i], tickets[k]);
            } else {
                res += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return res;
    }
}
