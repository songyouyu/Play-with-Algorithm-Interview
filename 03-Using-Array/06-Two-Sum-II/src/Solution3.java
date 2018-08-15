/**
 * leetcode 167
 * @author youyusong
 * @date 2018/8/15
 */
public class Solution3 {

    /**
     * 对撞指针
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("Illegal argument numbers");
        }

        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                int[] res = {l + 1, r + 1};
                return res;
            } else if (numbers[l] + numbers[r] < target) {
                l ++;
            } else {
                r --;
            }
        }
        throw new IllegalStateException("The input has no solution");
    }

}
