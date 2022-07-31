package design.a.food.rating.system;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author hum
 */
public class DesignAFoodRatingSystem {
  Map<String, String> map1 = new HashMap<>();
  Map<String, Integer> map2 = new HashMap<>();
  Map<String, TreeSet<P>> map3 = new HashMap<>();

  public DesignAFoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
    int len = foods.length;
    for (int i = 0; i < len; i++) {
      map1.put(foods[i], cuisines[i]);
      map2.put(foods[i], ratings[i]);
      map3.computeIfAbsent(cuisines[i], e -> new TreeSet<>((x, y) -> {
        int d = y.b - x.b;
        if (d == 0) {
          return x.a.compareTo(y.a);
        }
        return d;
      })).add(new P(foods[i], ratings[i]));
    }
  }

  public void changeRating(String food, int newRating) {
    P old = new P(food, map2.get(food));
    String s = map1.get(food);
    map3.get(s).remove(old);
    map2.put(food, newRating);
    map3.get(s).add(new P(food, newRating));
  }

  public String highestRated(String cuisine) {
    return map3.get(cuisine).first().a;
  }

  class P {
    String a;
    int b;

    public P(String a, int b) {
      this.a = a;
      this.b = b;
    }


  }
}
