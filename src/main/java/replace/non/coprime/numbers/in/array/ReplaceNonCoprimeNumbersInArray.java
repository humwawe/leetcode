package replace.non.coprime.numbers.in.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hum
 */
public class ReplaceNonCoprimeNumbersInArray {
  public List<Integer> replaceNonCoprimes(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    for (int num : nums) {
      while (!stack.isEmpty() && gcd(stack.peek(), num) > 1) {
        int pop = stack.pop();
        num = pop / gcd(pop, num) * num;
      }
      stack.push(num);
    }
    return new ArrayList<>(stack);
  }

  int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
