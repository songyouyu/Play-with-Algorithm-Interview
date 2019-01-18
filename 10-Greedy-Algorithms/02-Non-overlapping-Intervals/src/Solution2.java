import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 435
 * @author youyusong
 * @date 2018/8/31
 */
public class Solution2 {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {

        if(intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.end != o2.end) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });

        // 已排好序的区间, 第 0 号的元素, 第一个区间肯定是取的
        int res = 1;
        // 执行循环之前, 已经选择第 0 个区间
        int pre = 0;
        for(int i = 1 ; i < intervals.length ; i ++) {
            if(intervals[i].start >= intervals[pre].end){
                res ++;
                pre = i;
            }
        }

        return intervals.length - res;
    }
}
