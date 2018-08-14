/**
 * leetcode 283
 * @author youyusong
 * @date 2018/8/14
 */
public class Solution {

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param num
     */
    public void moveZeroes(int[] num) {

        // num数组中，[0...k)均为非0元素
        int k = 0;

        for (int i = 0; i < num.length; i ++) {
            if (num[i] != 0) {
                num[k] = num[i];
                k ++;
            }
        }

        for (int i = k; i < num.length; i ++) {
            num[i] = 0;
        }
    }
}
