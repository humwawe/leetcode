package generator;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hum
 */
public class Util {
    static Pattern pattern = Pattern.compile("\\$\\{([^}]+)}");

    @SuppressWarnings("unchecked")
    public static String simpleTemplate(String templateStr, Map<String, ?> map, String nullReplaceVal) {
        if (templateStr == null) {
            return null;
        }
        if (map == null) {
            map = Collections.EMPTY_MAP;
        }

        StringBuffer newValue = new StringBuffer(templateStr.length());
        Matcher matcher = pattern.matcher(templateStr);

        while (matcher.find()) {
            String key = matcher.group(1);
            String r = map.get(key) != null ? map.get(key).toString() : nullReplaceVal;
            // 这个是为了替换windows下的文件目录在java里用\\表示
            matcher.appendReplacement(newValue, r.replaceAll("\\\\", "\\\\\\\\"));
        }
        matcher.appendTail(newValue);
        return newValue.toString();
    }
}
