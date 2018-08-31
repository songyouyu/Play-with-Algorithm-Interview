import java.util.Arrays;

/**
 * leetcode 455
 * @author youyusong
 * @date 2018/8/31
 */
public class Solution1 {

    /**
     * 尝试满足最贪心的小朋友
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = g.length - 1;
        int si = s.length - 1;
        int res = 0;

        while (gi >= 0 && si >= 0) {
            if (s[si] >= g[gi]) {
                si --;
                gi --;
                res ++;
            } else {
                gi --;
            }
        }
        return res;
    }

}
