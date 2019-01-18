import java.util.HashMap;

/**
 * leetcode 1
 * @author youyusong
 * @date 2018/8/20
 */
public class Solution1 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> record = new HashMap<>(16);
        for (int i = 0; i < nums.length; i ++) {
            int complement = target - nums[i];
            if (record.containsKey(complement)) {
                // 在已遍历过的数据中，已找到数据
                int[] res = {i, record.get(complement)};
                return res;
            }
            record.put(nums[i], i);
        }
        throw new IllegalArgumentException("no solution");
    }

}
