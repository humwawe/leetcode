package alert.using.same.key.card.three.or.more.times.in.a.one.hour.period;

import java.util.*;

/**
 * @author hum
 */
public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int len = keyName.length;
        Integer[] idx = new Integer[len];
        for (int i = 0; i < len; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparing(x -> keyTime[x]));
        Map<String, Integer> map = new HashMap<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            int index = idx[i];
            while (!linkedList.isEmpty() && check(keyTime, linkedList.getFirst(), index)) {
                map.put(keyName[linkedList.getFirst()], map.get(keyName[linkedList.getFirst()]) - 1);
                linkedList.removeFirst();
            }
            linkedList.addLast(index);
            map.put(keyName[index], map.getOrDefault(keyName[index], 0) + 1);
            if (map.get(keyName[index]) >= 3) {
                set.add(keyName[index]);
            }
        }
        List<String> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }

    private boolean check(String[] t, int i, int j) {
        int hhi = Integer.parseInt(t[i].substring(0, 2));
        int mmi = Integer.parseInt(t[i].substring(3));
        int hhj = Integer.parseInt(t[j].substring(0, 2));
        int mmj = Integer.parseInt(t[j].substring(3));
        return hhj * 60 + mmj - hhi * 60 - mmi > 60;
    }
}
