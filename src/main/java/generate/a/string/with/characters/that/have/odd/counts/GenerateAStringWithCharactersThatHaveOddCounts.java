package generate.a.string.with.characters.that.have.odd.counts;

/**
 * @author hum
 */
public class GenerateAStringWithCharactersThatHaveOddCounts {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            sb.append('a');
            n--;
        }
        for (int i = 0; i < n; i++) {
            sb.append('b');
        }
        return sb.toString();
    }
}
