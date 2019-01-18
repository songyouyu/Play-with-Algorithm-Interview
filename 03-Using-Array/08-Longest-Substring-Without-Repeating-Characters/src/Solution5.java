import java.util.Arrays;

/**
 * @author youyusong
 * @date 2018/8/19
 */
public class Solution5 {

    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[256];

        // 将 last 数组每一个值都赋值为 -1
        Arrays.fill(last, -1);

        int l = 0;
        int r = -1;
        int res = 0;

        while (r + 1 < s.length()) {
            r ++;

            if (last[s.charAt(r)] != -1) {
                // l 直接跳转到上次出现的位置 +1 的地方
                l = Math.max(l, last[s.charAt(r)] + 1);
            }

            res = Math.max(res, r - l + 1);

            // 更新 r 出现的位置, 以便下一次循环若 r + 1 出现过，则直接跳转到此位置
            last[s.charAt(r)] = r;
        }
        return res;
    }

}
