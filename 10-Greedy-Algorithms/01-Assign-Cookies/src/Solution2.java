import java.util.Arrays;

/**
 * leetcode 455
 * @author youyusong
 * @date 2018/8/31
 */
public class Solution2 {

    /**
     * 先尝试满足最不贪心的小朋友
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0;
        int si = 0;
        int res = 0;

        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                res ++;
                si ++;
                gi ++;
            } else {
                si ++;
            }
        }
        return res;
    }
}
