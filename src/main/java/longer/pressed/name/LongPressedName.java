package longer.pressed.name;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        name = name + "$";
        typed = typed + "$";
        List<Integer> list = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Character> list4 = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i) != name.charAt(i - 1)) {
                list.add(count);
                list2.add(name.charAt(i - 1));
                count = 0;
            }
            count++;
        }
        count = 1;
        for (int i = 1; i < typed.length(); i++) {
            if (typed.charAt(i) != typed.charAt(i - 1)) {
                list3.add(count);
                list4.add(typed.charAt(i - 1));
                count = 0;
            }
            count++;
        }
        if (list.size() != list3.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!list2.get(i).equals(list4.get(i)) || list.get(i) > list3.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongPressedName longPressedName = new LongPressedName();
        System.out.println(longPressedName.isLongPressedName("alex", "aaleex"));
    }
}
