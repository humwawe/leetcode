package design.browser.history;

/**
 * @author hum
 */
public class DesignBrowserHistory {
    String[] strings;
    int idx = -1;
    int size = 0;

    public DesignBrowserHistory(String homepage) {
        strings = new String[5000];
        strings[++idx] = homepage;
        size = idx + 1;
    }

    public void visit(String url) {
        strings[++idx] = url;
        size = idx + 1;
    }

    public String back(int steps) {
        int i = idx - steps;
        idx = Math.max(0, i);
        return strings[idx];
    }

    public String forward(int steps) {
        int i = idx + steps;
        idx = Math.min(i, size - 1);
        return strings[idx];
    }
}
