package sort.items.by.groups.respecting.dependencies;

import java.util.*;

/**
 * @author hum
 */
public class SortItemsByGroupsRespectingDependencies {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int[] Indegree = new int[n];
        int course = n;
        Queue<Integer> queueG = new LinkedList<>();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();//组间关系
        HashMap<Integer, ArrayList<Integer>> groupmap = new HashMap<>(); //组长组员关系
        HashMap<Integer, HashSet<Integer>> ingroup = new HashMap<>(); //组内关系

        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
            ArrayList<Integer> list = groupmap.getOrDefault(group[i], new ArrayList<>());
            list.add(i);
            groupmap.put(group[i], list);
        }

        int[] inGroup = new int[m];
        int[] res = new int[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            int g = group[i];
            for (int j = 0; j < beforeItems.get(i).size(); j++) {
                int p = beforeItems.get(i).get(j);
                int g1 = group[p];
                if (g != g1) {
                    HashSet<Integer> set = map.getOrDefault(g1, new HashSet<Integer>());
                    if (!set.contains(g)) {
                        inGroup[g]++;
                    }
                    set.add(g);
                    map.put(g1, set);
                } else {
                    Indegree[i]++;
                    HashSet<Integer> set1 = ingroup.getOrDefault(p, new HashSet<Integer>());
                    set1.add(i);
                    ingroup.put(p, set1);
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        int cr = groupmap.size();
        for (int group1 : groupmap.keySet()) {
            if (inGroup[group1] == 0) {
                queueG.add(group1);
            }
        }
        while (!queueG.isEmpty()) {
            int x = queueG.poll();
            list.add(x);
            if (map.containsKey(x)) {
                HashSet<Integer> set = map.get(x);
                for (int i : set) {
                    if (--inGroup[i] == 0) queueG.add(i);
                }
            }
        }
        if (list.size() < cr) {
            return new int[]{};
        }

        for (int l = 0; l < list.size(); l++) {
            Queue<Integer> queue = new LinkedList<>();
            int gr = list.get(l);
            ArrayList<Integer> groupl = groupmap.get(gr);
            for (int x = 0; x < groupl.size(); x++) {
                int nn = groupl.get(x);
                if (Indegree[nn] == 0) {
                    queue.add(nn);
                }
            }
            int count = groupl.size();
            while (!queue.isEmpty()) {
                int num = queue.poll();
                res[index++] = num;
                course--;
                count--;
                if (ingroup.containsKey(num)) {
                    HashSet<Integer> fl = ingroup.get(num);
                    for (int number : fl) {
                        if (--Indegree[number] == 0) {
                            queue.add(number);
                        }
                    }
                }
            }
            if (count != 0) {
                return new int[]{};
            }
        }
        return course == 0 ? res : new int[]{};
    }

}
