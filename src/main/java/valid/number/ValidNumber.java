package valid.number;

/**
 * @author hum
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if (s.length() == 0 || (s = s.trim()).length() == 0) {
            return false;
        }

        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }

        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (state) {
                case 0:
                    if (c >= '0' && c <= '9') {
                        state = 1;
                    } else if (c == '.') {
                        state = 7;
                    } else {
                        return false;
                    }
                    break;
                case 1:
                    if (c >= '0' && c <= '9') {
                        state = 1;
                    } else if (c == '.') {
                        state = 2;
                    } else if (c == 'e') {
                        state = 3;
                    } else {
                        return false;
                    }
                    break;
                case 2:
                    if (c >= '0' && c <= '9') {
                        state = 4;
                    } else if (c == 'e') {
                        state = 3;
                    } else {
                        return false;
                    }
                    break;
                case 3:
                    if (c >= '0' && c <= '9') {
                        state = 6;
                    } else if (c == '-' || c == '+') {
                        state = 5;
                    } else {
                        return false;
                    }
                    break;
                case 4:
                    if (c >= '0' && c <= '9') {
                        state = 4;
                    } else if (c == 'e') {
                        state = 3;
                    } else {
                        return false;
                    }
                    break;
                case 5:
                    if (c >= '0' && c <= '9') {
                        state = 6;
                    } else {
                        return false;
                    }
                    break;
                case 6:
                    if (c >= '0' && c <= '9') {
                        state = 6;
                    } else {
                        return false;
                    }
                    break;
                case 7:
                    if (c >= '0' && c <= '9') {
                        state = 4;
                    } else {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }

        return state == 6 || state == 4 || state == 1 || state == 2;
    }
}

