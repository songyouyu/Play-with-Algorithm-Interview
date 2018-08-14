import java.util.ArrayList;

/**
 * leetcode 283
 * @author youyusong
 * @date 2018/8/14
 */
public class Solution {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：0(n)
     * @param num
     */
    public void moveZeroes(int[] num) {
        ArrayList<Integer> list = new ArrayList<>();

        // 将数组中所有非0元素放入list
        for (int i = 0; i < num.length; i ++) {
            if (num[i] != 0) {
                list.add(num[i]);
            }
        }

        // 将list中所有元素依次放入num
        for (int i = 0; i < list.size(); i ++) {
            num[i] = list.get(i);
        }

        // 将num数组中剩余的位置补0
        for (int i = list.size(); i < num.length; i ++) {
            num[i] = 0;
        }
    }

}
