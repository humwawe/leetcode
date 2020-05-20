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

    public int[] distributeCandies2(int candies, int numPeople) {
        int[] result = new int[numPeople];
        int p = (int) (Math.sqrt(2 * candies + 0.25) - 0.5);
        int last = candies - p * (p + 1) / 2;
        int row = p / numPeople;
        int idx = p % numPeople;
        System.out.println(row);
        System.out.println(p);
        for (int i = 0; i < result.length; i++) {
            result[i] = ((i + 1) + (i + 1 + numPeople * (row - 1))) * row / 2;
            if (i < idx) {
                result[i] += i + 1 + numPeople * row;
            }
        }
        result[idx] += last;
        return result;
    }

}
