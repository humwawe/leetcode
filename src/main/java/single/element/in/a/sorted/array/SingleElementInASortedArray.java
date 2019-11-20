package single.element.in.a.sorted.array;

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r + l) / 2;
            if(mid % 2 == 0  && nums[mid] != nums[mid + 1] || mid % 2 == 1 && nums[mid] == nums[mid + 1]){
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
