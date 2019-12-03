package tag.validator;

import java.util.Stack;

public class TagValidator {
    Stack<String> stack = new Stack<>();
    private boolean containsTag = false;

    public boolean isValid(String code) {
        if (code.charAt(0) != '<' || code.charAt(code.length() - 1) != '>') {
            return false;
        }
        for (int i = 0; i < code.length(); i++) {
            boolean ending = false;
            int closeIndex;
            if (stack.isEmpty() && containsTag) {
                return false;
            }
            if (code.charAt(i) == '<') {
                if (!stack.isEmpty() && code.charAt(i + 1) == '!') {
                    closeIndex = code.indexOf("]]>", i + 1);
                    if (closeIndex < 0 || !isValidCdata(code.substring(i + 2, closeIndex))) {
                        return false;
                    }
                } else {
                    if (code.charAt(i + 1) == '/') {
                        i++;
                        ending = true;
                    }
                    closeIndex = code.indexOf('>', i + 1);
                    if (closeIndex < 0 || !isValidTagName(code.substring(i + 1, closeIndex), ending)) {
                        return false;
                    }
                }
                i = closeIndex;
            }
        }
        return stack.isEmpty() && containsTag;
    }

    private boolean isValidTagName(String s, boolean ending) {
        if (s.length() < 1 || s.length() > 9) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isUpperCase(s.charAt(i))) {
                return false;
            }
        }
        if (ending) {
            if (!stack.isEmpty() && stack.peek().equals(s)) {
                stack.pop();
            } else {
                return false;
            }
        } else {
            containsTag = true;
            stack.push(s);
        }
        return true;
    }

    private boolean isValidCdata(String s) {
        return s.indexOf("[CDATA[") == 0;
    }

}
