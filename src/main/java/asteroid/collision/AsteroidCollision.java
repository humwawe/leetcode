package asteroid.collision;


import java.util.Stack;

/**
 * @author hum
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid < 0) {
                boolean flag = false;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (stack.peek() < -asteroid) {
                        stack.pop();
                    } else if (stack.peek() == -asteroid) {
                        stack.pop();
                        flag = true;
                        break;
                    } else {
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
            } else {
                stack.push(asteroid);
            }
        }
        int size = stack.size();
        int[] result = new int[size];
        while (!stack.isEmpty()) {
            result[--size] = stack.pop();
        }
        return result;
    }
}
