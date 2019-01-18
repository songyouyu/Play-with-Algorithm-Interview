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
            HashMap<Integer, Integer> record = new HashMap<>(16);
            for (int j = 0; j < points.length; j ++) {
               if (j != i) {
                    int dis = dis(points[i], points[j]);
                    if (record.containsKey(dis)) {
                        // 只有 value = 2 时，才可能会有答案
                        record.put(dis, record.get(dis) + 1);
                    } else {
                        record.put(dis, 1);
                    }
               }
            }
            for (Integer item : record.keySet()) {
                // 若只出现 1 次，则 1-1=0，所以不用判断 value 是否大于等于 2
                res += record.get(item) * (record.get(item) - 1);
            }
        }

        return res;
    }

    private int dis(int[] pa, int pb[]){
        // x^2 + y^2, 不开根号，这样不会有浮点值
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) +
                (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = {{0,0},{1,0},{2,0}};
        int i = solution.numberOfBoomerangs(points);
        System.out.println(i);
    }
}
