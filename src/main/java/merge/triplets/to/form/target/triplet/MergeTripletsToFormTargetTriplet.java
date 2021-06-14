package merge.triplets.to.form.target.triplet;

/**
 * @author hum
 */
public class MergeTripletsToFormTargetTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] res = new int[3];
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            for (int i = 0; i < 3; i++) {
                res[i] = Math.max(res[i], triplet[i]);
            }
        }
        for (int i = 0; i < 3; i++) {
            if (res[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
