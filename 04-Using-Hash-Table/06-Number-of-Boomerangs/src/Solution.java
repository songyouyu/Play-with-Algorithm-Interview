import java.util.HashMap;

/**
 * leetcode 447
 * @author youyusong
 * @date 2018/8/20
 */
public class Solution {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i ++) {
            // record 存放点 i 到其他所有点出现的频次
            HashMap<Integer, Integer> record = new HashMap<>();
            for (int j = 0; j < points.length; j ++) {
               if (j != i) {
                    int dis = dis(points[i], points[j]);
                    if (record.containsKey(dis)) {
                        record.put(dis, record.get(dis) + 1);
                    } else {
                        record.put(dis, 1);
                    }
               }
            }
            for (Integer item : record.keySet()) {
                res += record.get(item) * (record.get(item) - 1);
            }
        }
        return res;

    }

    private int dis(int[] pa, int pb[]){
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) +
                (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }
}
