import java.util.TreeSet;

/**
 * leetcode 349
 * @author youyusong
 * @date 2018/8/19
 */
public class Solution {

    /**
     * 给定两个数组,求两个数组的交集,忽略重复元素
     * 时间复杂度: O(nlogn)
     * 空间复杂度: O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> record = new TreeSet<>();

        for (int i = 0; i < nums1.length; i ++) {
            record.add(nums1[i]);
        }

        TreeSet<Integer> resultSet = new TreeSet<>();
        for (int i = 0; i < nums2.length; i ++) {
            if (record.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }

        int[] res = new int[resultSet.size()];
        int index = 0;
        for (Integer num : resultSet) {
            res[index] = num;
            index ++;
        }
        return res;
    }

}
