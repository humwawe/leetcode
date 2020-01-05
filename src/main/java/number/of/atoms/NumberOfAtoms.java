package number.of.atoms;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author hum
 */
public class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        Stack<Node> stack = new Stack<>();
        int len = formula.length();
        for (int i = 0; i < len; ) {
            StringBuilder tmp = new StringBuilder();
            if (Character.isUpperCase(formula.charAt(i))) {
                tmp.append(formula.charAt(i));
                i++;
                while (i < len && Character.isLowerCase(formula.charAt(i))) {
                    tmp.append(formula.charAt(i));
                    i++;
                }
                stack.push(new Node(tmp.toString(), 1));
            } else if (formula.charAt(i) == '(') {
                i++;
                stack.push(new Node("(", -1));
            } else if (formula.charAt(i) == ')') {
                i++;
                stack.push(new Node(")", -1));
            } else {
                int num = 0;
                while (i < len && Character.isDigit(formula.charAt(i))) {
                    num *= 10;
                    num += formula.charAt(i) - '0';
                    i++;
                }
                Node peek = stack.peek();
                if (peek.node.equals(")")) {
                    Stack<Node> t = new Stack<>();
                    stack.pop();
                    while (!stack.peek().node.equals("(")) {
                        peek = stack.pop();
                        t.push(peek);
                        peek.num = peek.num * num;
                    }
                    stack.pop();
                    while (!t.isEmpty()) {
                        stack.push(t.pop());
                    }
                } else {
                    peek.num = peek.num * num;
                }
            }
        }
        Map<String, Integer> map = new TreeMap<>();
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            map.put(pop.node, map.getOrDefault(pop.node, 0) + pop.num);
        }
        StringBuilder result = new StringBuilder();
        for (String s : map.keySet()) {
            result.append(s);
            int num = map.get(s);
            if (num != 1) {
                result.append(num);
            }
        }
        return result.toString();
    }

    class Node {
        String node;
        int num;

        public Node(String node, int num) {
            this.node = node;
            this.num = num;
        }
    }
}
