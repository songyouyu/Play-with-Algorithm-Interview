import javafx.util.Pair;

import java.util.LinkedList;

/**
 * leetcode 279
 * @author youyusong
 * @date 2018/8/27
 */
public class Solution2 {

    /**
     * 优化: 图中广度优先遍历
     * @param n
     * @return
     */
    public int numSquares(int n) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        // 具体第几个数字   经历了几段路径走到这个数字
        // 初始化时，对于 n 这个数字，一步都没有走，0 步就到达了
        queue.addLast(new Pair<>(n, 0));

        // 从 0 到 n 个， 一共 n + 1 个数字，标记元素是否被访问过,传入进来的元素是被访问过的
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while ( !queue.isEmpty() ) {
            Pair<Integer, Integer> front = queue.removeLast();
            int num = front.getKey();
            int step = front.getValue();

            // 已经找到从 n 到 0 的路径，经历 step
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
