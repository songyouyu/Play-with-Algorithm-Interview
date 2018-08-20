import java.util.HashMap;

/**
 * leetcode 1
 * @author youyusong
 * @date 2018/8/20
 */
public class Solution2 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> record = new HashMap<>();

        // record 中记录的是每一个元素最后一次出现的索引位置
        for (int i = 0; i < nums.length; i ++) {
            record.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i ++) {
            if (record.containsKey(target - nums[i])) {
                if ( i != record.get(target - nums[i])) {
                    int[] res = {i, record.get(target - nums[i])};
                    return res;
                }
            }
        }
        throw new IllegalArgumentException("no solution");
    }
}
