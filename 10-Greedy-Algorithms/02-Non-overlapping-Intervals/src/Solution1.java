import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 435
 * @author youyusong
 * @date 2018/8/31
 */
public class Solution1 {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }


        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });

        int[] memo = new int[intervals.length];
        // 把第 i 个区间自己拿出来, 这个区间的长度只有 1, 此时这个区间肯定是不重叠的
        Arrays.fill(memo, 1);

        // 最长不重叠区间
        for (int i = 1; i < intervals.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (intervals[i].start >= intervals[j].end) {
                    // 以第 j 个区间结尾的最长不重叠区间序列, + 1 表示当前考察的 intervals[i] 这个区间
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < memo.length; i ++) {
            res = Math.max(res, memo[i]);
        }
        return intervals.length - res;
    }
}
