import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap hs = new HashMap<>();
        var result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hs.get(nums[i]) != null) {
                result[0] = (int) hs.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                hs.put(target - nums[i], i);
            }
        }
        return result;
    }

}
