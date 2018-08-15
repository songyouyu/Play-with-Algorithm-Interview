/**
 * leetcode 167
 * @author youyusong
 * @date 2018/8/15
 */
public class Solution1 {

    /**
     * 暴力破解
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("Illegal argument numbers");
        }

        for (int i = 0; i < numbers.length; i ++) {
            for (int j = i + 1; j < numbers.length; j ++) {
                if (numbers[i] + numbers[j] == target) {
                    int[] res = {i + 1, j + 1};
                    return res;
                }
            }
        }
        throw new IllegalStateException("The input has no solution");
    }
}
