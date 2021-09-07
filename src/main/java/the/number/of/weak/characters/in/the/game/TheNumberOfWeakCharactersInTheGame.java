package the.number.of.weak.characters.in.the.game;

import java.util.Arrays;

/**
 * @author hum
 */
public class TheNumberOfWeakCharactersInTheGame {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        int cnt = 0;
        int max = -1;
        for (int[] property : properties) {
            if (max > property[1]) {
                cnt++;
            }
            max = Math.max(max, property[1]);
        }
        return cnt;
    }
}
