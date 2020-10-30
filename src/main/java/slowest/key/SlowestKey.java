package slowest.key;

/**
 * @author hum
 */
public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = 'a';
        int time = 0;
        int len = releaseTimes.length;
        int last = 0;
        for (int i = 0; i < len; i++) {
            int t = releaseTimes[i] - last;
            if (t > time || (t == time && keysPressed.charAt(i) > res)) {
                res = keysPressed.charAt(i);
                time = t;
            }
            last = releaseTimes[i];
        }
        return res;
    }
}
