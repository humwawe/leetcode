package reconstruct.itinerary;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author hum
 */
public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort(Comparator.comparing(c -> c.get(1)));
        int len = tickets.size();
        List<String> result = new ArrayList<>();
        boolean[] visit = new boolean[len];
        helper(tickets, "JFK", result, visit);
        result.add(0, "JFK");
        return result;

    }

    private void helper(List<List<String>> tickets, String start, List<String> result, boolean[] visit) {
        for (int i = 0; i < tickets.size(); i++) {
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            if (!visit[i] && from.equals(start)) {
                visit[i] = true;
                result.add(to);
                helper(tickets, to, result, visit);
                if (result.size() == tickets.size()) {
                    return;
                }
                visit[i] = false;
                result.remove(result.size() - 1);
            }

        }
    }
}
