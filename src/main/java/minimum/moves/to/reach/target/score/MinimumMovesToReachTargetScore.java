package minimum.moves.to.reach.target.score;

/**
 * @author hum
 */
public class MinimumMovesToReachTargetScore {
    public int minMoves(int target, int maxDoubles) {
        int res = 0;
        while (target != 1 && maxDoubles > 0) {
            if (target % 2 == 1) {
                target--;
            } else {
                maxDoubles--;
                target /= 2;
            }
            res++;
        }
        res += target - 1;
        return res;
    }
}
