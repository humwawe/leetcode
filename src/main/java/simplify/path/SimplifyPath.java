package simplify.path;

/**
 * @author hum
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        StringBuilder result = new StringBuilder();
        for (String path1 : paths) {
            if (path1.isEmpty() || ".".equals(path1)) {
                continue;
            } else if (!"..".equals(path1)) {
                result.append("/").append(path1);
            } else {
                if (result.length() == 0) {
                    continue;
                }
                result.delete(result.lastIndexOf("/"), result.length());
            }
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}
