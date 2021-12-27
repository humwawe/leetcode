package find.all.possible.recipes.from.given.supplies;

import java.util.*;

/**
 * @author hum
 */
public class FindAllPossibleRecipesFromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, supplies);
        List<String> res = new ArrayList<>();
        boolean[] vis = new boolean[recipes.length];
        while (true) {
            boolean flag = false;
            for (int i = 0; i < recipes.length; i++) {
                if (vis[i]) {
                    continue;
                }
                List<String> list = ingredients.get(i);
                if (set.containsAll(list)) {
                    flag = true;
                    set.add(recipes[i]);
                    vis[i] = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        for (int i = 0; i < recipes.length; i++) {
            if (vis[i]) {
                res.add(recipes[i]);
            }
        }
        return res;
    }
}
