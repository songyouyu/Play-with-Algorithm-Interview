import javafx.util.Pair;

import java.util.LinkedList;

/**
 * leetcode 279
 * @author youyusong
 * @date 2018/8/27
 */
public class Solution1 {

    /**
     * 会超时或内存溢出
     * 在 for 循环位置会出现大量重复记录,比如对于 1 这个数字, 2-1=1, 5-4=1
     * @param n
     * @return
     */
    public int numSquares(int n) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));

        while ( !queue.isEmpty() ) {
            Pair<Integer, Integer> front = queue.removeLast();
            int num = front.getKey();
            int step = front.getValue();

            if (num == 0) {
                return step;
            }

            for (int i = 1;  num - i * i >= 0; i ++) {
                queue.addLast(new Pair<>(num - i * i, step + 1));
            }
        }
        throw new IllegalArgumentException("no solution");
    }
}
