/**
 * leetcode 75
 * @author youyusong
 * @date 2018/8/15
 */
public class Solution {

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(k), k为元素的取值范围
     * @param nums
     */
    public void sortColors(int[] nums) {

        // 存放 0, 1, 2 三个数出现的次数
        int[] count = {0, 0,0};

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] < 0 || nums[i] > 2) {
                throw new IllegalArgumentException("数组中数据只能在 0-2 之间");
            }
            count[nums[i]] ++;
        }

        int index = 0;
        for (int i = 0; i < count[0]; i ++) {
            nums[index] = 0;
            index ++;
        }
        for (int i = 0; i < count[1]; i ++) {
            nums[index] = 1;
            index ++;
        }
        for (int i = 0; i < count[2]; i ++) {
            nums[index] = 2;
            index ++;
        }
    }
}
