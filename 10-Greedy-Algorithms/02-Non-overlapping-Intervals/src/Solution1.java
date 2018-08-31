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
        Arrays.fill(memo, 1);

        // 最长不重叠区间
        for (int i = 1; i < intervals.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (intervals[i].start >= intervals[j].end) {
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
