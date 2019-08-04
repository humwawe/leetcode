package remove.duplicate.letters;

import isomorphic.strings.IsomorphicStrings;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author hum
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                Integer count = map.get(c) + 1;
                map.put(c, count);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.get(c) - 1);
            if (set.contains(c)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) >= 1) {
                set.remove(stack.peek());
                stack.pop();
            }
            stack.push(c);
            set.add(c);
        }
        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result = result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
