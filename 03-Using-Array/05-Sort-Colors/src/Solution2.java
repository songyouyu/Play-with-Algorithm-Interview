/**
 * @author youyusong
 * @date 2018/8/15
 */
public class Solution2 {

    /**
     * 使用快速排序的三路快排思想
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param nums
     */
    public void sortColors(int[] nums) {

        // [0...zero] 为 0 的区间
        int zero = -1;
        // [two...nums.length - 1] 为 2 的区间
        int two = nums.length;

        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i ++;
            } else if (nums[i] == 2) {
                two --;
                swap(nums, i, two);
            } else {
                zero ++;
                swap(nums, zero, i);
                i ++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]= nums[j];
        nums[j] = t;
    }
}
