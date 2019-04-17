package roman_to_integer;


/**
 * @author hum
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        int index = 0;
        while (index < s.length() - 1) {
            switch (s.charAt(index)) {
                case 'I':
                    if (s.charAt(index + 1) == 'V') {
                        result += 4;
                        index += 2;
                    } else if (s.charAt(index + 1) == 'X') {
                        result += 9;
                        index += 2;
                    } else {
                        result += 1;
                        index += 1;
                    }
                    break;
                case 'V':
                    result += 5;
                    index += 1;
                    break;
                case 'X':
                    if (s.charAt(index + 1) == 'L') {
                        result += 40;
                        index += 2;
                    } else if (s.charAt(index + 1) == 'C') {
                        result += 90;
                        index += 2;
                    } else {
                        result += 10;
                        index += 1;
                    }
                    break;
                case 'L':
                    result += 50;
                    index += 1;
                    break;
                case 'C':
                    if (s.charAt(index + 1) == 'D') {
                        result += 400;
                        index += 2;
                    } else if (s.charAt(index + 1) == 'M') {
                        result += 900;
                        index += 2;
                    } else {
                        result += 100;
                        index += 1;
                    }
                    break;
                case 'D':
                    result += 500;
                    index += 1;
                    break;
                case 'M':
                    result += 1000;
                    index += 1;
                    break;
                default:
                    break;
            }
        }
        if (index == s.length() - 1) {
            switch (s.charAt(index)) {
                case 'I':
                    result += 1;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
                default:
                    break;
            }
        }
        return result;
    }

}
