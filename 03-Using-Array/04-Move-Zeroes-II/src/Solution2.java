/**
 * @author youyusong
 * @date 2018/8/14
 */
public class Solution2 {

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param num
     */
    public void moveZeroes(int[] num) {

        int k = 0;

        for (int i = 0; i < num.length; i ++) {
            if (num[i] != 0) {
                swap(num, k, i);
                k ++;
            }
        }
    }

    private void swap(int[] num, int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
}
