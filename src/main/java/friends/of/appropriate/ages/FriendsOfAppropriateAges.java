package friends.of.appropriate.ages;

/**
 * @author hum
 */
public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        int[] tmp = new int[121];
        for (int age : ages) {
            tmp[age]++;
        }
        int result = 0;
        for (int i = 1; i <= 120; i++) {
            for (int j = 1; j <= 120; j++) {
                if (tmp[i] != 0 && tmp[j] != 0) {
                    if (!(j <= 0.5 * i + 7 || j > i || (j > 100 && i < 100))) {
                        if (i == j) {
                            result += tmp[i] * (tmp[j] - 1);
                        } else {
                            result += tmp[i] * tmp[j];
                        }

                    }
                }
            }
        }
        return result;
    }
}
