package distribute.candies.to.people;

/**
 * @author hum
 */
public class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int numPeople) {
        int[] result = new int[numPeople];
        int i = 0;
        while (candies > 0) {
            if (candies > i + 1) {
                result[i % numPeople] += i + 1;
                candies -= i + 1;
            } else {
                result[i % numPeople] += candies;
                break;
            }
            i++;
        }
        return result;
    }
}
