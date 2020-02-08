package chalkboard.xor.game;


/**
 * @author hum
 */
public class ChalkboardXorGame {
    public boolean xorGame(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        return x == 0 || nums.length % 2 == 0;
    }
}
