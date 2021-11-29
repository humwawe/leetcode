package find.all.people.with.secret;

import java.util.*;

/**
 * @author hum
 */
public class FindAllPeopleWithSecret {
    int[] p;

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        p[firstPerson] = 0;
        Arrays.sort(meetings, Comparator.comparingInt(x -> x[2]));

        for (int i = 0; i < meetings.length; ) {
            int time = meetings[i][2];
            int j = i;
            Set<Integer> set = new HashSet<>();
            while (j < meetings.length && meetings[j][2] == time) {
                int a = meetings[j][0];
                int b = meetings[j][1];
                p[find(a)] = find(b);
                set.add(a);
                set.add(b);
                j++;
            }
            i = j;
            int root = find(0);
            List<Integer> good = new ArrayList<>();
            for (Integer integer : set) {
                if (find(integer) == root) {
                    good.add(integer);
                } else {
                    p[integer] = integer;
                }
            }
            p[0] = 0;
            p[firstPerson] = 0;
            for (Integer integer : good) {
                p[integer] = 0;
            }

        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (p[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
