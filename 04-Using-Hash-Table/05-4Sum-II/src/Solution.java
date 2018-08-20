import java.util.HashMap;

/**
 * leetcode 454
 * @author youyusong
 * @date 2018/8/20
 */
public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < B.length; j ++) {
                if (record.containsKey(A[i] + B[j])) {
                    record.put(A[i] + B[j], record.get(A[i] + B[j]) + 1);
                } else {
                    record.put(A[i] + B[j], 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < C.length; i ++) {
            for (int j = 0; j < D.length; j ++) {
                if (record.containsKey(0 - C[i] - D[j])) {
                    res += record.get(0 - C[i] - D[j]);
                }
            }
        }

        return res;
    }

}
