import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 51(8皇后问题)
 * @author youyusong
 * @date 2018/8/29
 */
public class Solution {

    /**
     * 代表每一行的每一个方块
     */
    private boolean[] col;

    /**
     * 左对角线
     */
    private boolean[] dia1;

    /**
     * 右对角线
     */
    private boolean[] dia2;

    /**
     * 存储结果
     */
    private ArrayList<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        LinkedList<Integer> row = new LinkedList<>();
        putQueue(n, 0, row);
        return res;

    }

    /**
     * 尝试摆放第 index 行皇后的位置
     *
     * @param n
     * @param index
     * @param row
     */
    private void putQueue(int n, int index, LinkedList<Integer> row) {
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }
        for (int i = 0; i < n; i++) {
            // index : 第几行    i : 第几列
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row.addLast(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueue(n, index + 1, row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.removeLast();
            }
        }
        return;
    }

    private List<String> generateBoard(int n, LinkedList<Integer> row) {
        ArrayList<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }
}