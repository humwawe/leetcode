package unique.email.addresses;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            email = email.replaceAll("\\+.*@", "@");
            System.out.println(email);
            StringBuilder stringBuilder = new StringBuilder();
            boolean flag = false;
            for (char c : email.toCharArray()) {
                if (flag) {
                    stringBuilder.append(c);
                } else {
                    if (c == '@') {
                        flag = true;
                    }
                    if (c != '.') {
                        stringBuilder.append(c);
                    }
                }
            }
            System.out.println(stringBuilder.toString());
            set.add(stringBuilder.toString());
        }
        return set.size();
    }
}
