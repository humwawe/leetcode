package validate.ip.address;

import java.util.Arrays;

/**
 * @author hum
 */
public class ValidateIpAddress {
    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            String[] ips = IP.split("\\.");
            if (ips.length == 4 && !IP.startsWith(".") && !IP.endsWith(".")) {
                boolean flag = true;
                for (String ip : ips) {
                    if (!isNumeric(ip) || isZeorStart(ip) || ip.length() > 3 || !lessThan256(ip)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return "IPv4";
                }

            }
        } else if (IP.contains(":")) {
            String[] ips = IP.split(":");
            if (ips.length == 8 && !IP.startsWith(":") && !IP.endsWith(":")) {
                boolean flag = true;
                for (String ip : ips) {
                    if (ip.length() > 4 || ip.length() == 0 || !isNumericOrAlphabet(ip)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return "IPv6";
                }
            }
        }
        return "Neither";
    }

    private boolean isNumericOrAlphabet(String str) {
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (!(Character.isDigit(tmp) || Character.isAlphabetic(tmp)) || Character.toUpperCase(str.charAt(i)) >= 'G') {
                return false;
            }
        }
        return true;
    }


    private boolean lessThan256(String ip) {
        return Integer.valueOf(ip) < 256;
    }


    private boolean isZeorStart(String ip) {
        return ip.startsWith("0") && ip.length() > 1;
    }

    private boolean isNumeric(String str) {
        if (str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("12:123:12:".split(":")));
        System.out.println(Integer.valueOf("01"));
    }
}

