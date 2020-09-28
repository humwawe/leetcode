package crawler.log.folder;

/**
 * @author hum
 */
public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int res = 0;
        for (String l : logs) {
            if (l.startsWith("./")) {
                continue;
            }
            if (l.startsWith("..")) {
                res--;
                if (res < 0) {
                    res = 0;
                }
            } else {
                res++;
            }
        }
        return res;
    }
}
