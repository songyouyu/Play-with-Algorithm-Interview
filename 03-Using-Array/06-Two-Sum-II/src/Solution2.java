/**
 * leetcode 167
 * @author youyusong
 * @date 2018/8/15
 */
public class Solution2 {

    /**
     * 二分搜索法
     * 时间复杂度: O(nlogn)
     * 空间复杂度: O(1)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("Illegal argument numbers");
        }

        // 在数组numbers[i + 1...numbers.length - 1]区间中找到target - numbers[i]所对应的索引
        for (int i = 0; i < numbers.length; i ++) {
            int j = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (j != -1) {
                int[] res = {i + 1, j + 1};
                return res;
            }
        }
        throw new IllegalStateException("The input has no solution");
    }

    private int binarySearch(int[] nums, int l, int r, int target){

        if(l < 0 || l > nums.length) {
            throw new IllegalArgumentException("l is out of bound");
        }

        if(r < 0 || r > nums.length) {
            throw new IllegalArgumentException("r is out of bound");
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

}
