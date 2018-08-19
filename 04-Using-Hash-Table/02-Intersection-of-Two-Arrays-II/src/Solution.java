import java.util.ArrayList;
import java.util.HashMap;

/**
 * leetcode 350
 * @author youyusong
 * @date 2018/8/19
 */
public class Solution {

    /**
     * 给定两个数组,求两个数组的交集,计较重复元素
     * 时间复杂度: O(nlogn)
     * 空间复杂度: O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> record = new HashMap<>();
        for (Integer num : nums1) {
            if (record.containsKey(num)) {
                record.put(num, record.get(num) + 1);
            } else {
                record.put(num, 1);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer num : nums2) {
            if (record.containsKey(num) && record.get(num) > 0) {
                arrayList.add(num);
                record.put(num, record.get(num) - 1);
            }
        }

        int[] res = new int[arrayList.size()];
        int index = 0;
        for (Integer item : arrayList) {
            res[index] = item;
            index ++;
        }

        return res;
    }
}
