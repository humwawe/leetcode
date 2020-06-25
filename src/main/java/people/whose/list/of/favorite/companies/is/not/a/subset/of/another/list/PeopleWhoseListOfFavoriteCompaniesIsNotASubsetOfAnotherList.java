package people.whose.list.of.favorite.companies.is.not.a.subset.of.another.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author hum
 */
public class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        int len = favoriteCompanies.size();
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = 0; j < len; j++) {
                if (i == j || favoriteCompanies.get(i).size() >= favoriteCompanies.get(j).size()) {
                    continue;
                }
                flag = new HashSet<>(favoriteCompanies.get(j)).containsAll(favoriteCompanies.get(i));
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                res.add(i);
            }
        }
        return res;
    }
}
