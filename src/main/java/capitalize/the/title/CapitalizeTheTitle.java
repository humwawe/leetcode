package capitalize.the.title;

/**
 * @author hum
 */
public class CapitalizeTheTitle {
    public String capitalizeTitle(String title) {
        String[] s = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s1 : s) {
            if (s1.length() <= 2) {
                sb.append(s1.toLowerCase()).append(" ");
            } else {
                sb.append(s1.toUpperCase().charAt(0)).append(s1.toLowerCase().substring(1)).append(" ");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }
}
