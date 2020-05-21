package defanging.an.ip.address;

/**
 * @author hum
 */
public class DefangingAnIpAddress {
    public String defangIPaddr(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                stringBuilder.append("[.]");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
