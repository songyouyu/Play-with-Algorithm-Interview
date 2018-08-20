import java.util.HashSet;
import java.util.TreeSet;

/**
 * leetcode 349
 * @author youyusong
 * @date 2018/8/20
 */
public class Solution1 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> record = new HashSet<>();

        for (int i = 0; i < nums1.length; i ++) {
            record.add(nums1[i]);
        }

        HashSet<Integer> resultSet = new HashSet<>();
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
