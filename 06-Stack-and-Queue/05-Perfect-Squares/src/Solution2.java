import javafx.util.Pair;

import java.util.LinkedList;

/**
 * leetcode 279
 * @author youyusong
 * @date 2018/8/27
 */
public class Solution2 {

    /**
     * 优化
     * @param n
     * @return
     */
    public int numSquares(int n) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));

        // 标记元素是否被访问过,传入进来的元素是被访问过的
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while ( !queue.isEmpty() ) {
            Pair<Integer, Integer> front = queue.removeLast();
            int num = front.getKey();
            int step = front.getValue();

            if (num == 0) {
                return step;
            }

            // 对于 num - i * i, 重复计算了
            for (int i = 1;  num - i * i >= 0; i ++) {
                int result = num - i * i;
                if (! visited[result]) {
                    queue.addLast(new Pair<>(result, step + 1));
                    visited[result] = true;
                }
            }
        }
        throw new IllegalArgumentException("no solution");
    }
}
