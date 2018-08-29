/**
 * leetcode 79
 * @author youyusong
 * @date 2018/8/29
 */
public class Solution {

    private int m;
    private int n;
    private boolean[][] visited;
    private int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            throw new IllegalArgumentException("exception");
        }

        // 行
        m = board.length;
        // 列
        n = board[0].length;
        if (m == 0 || n == 0) {
            throw new IllegalArgumentException("exception");
        }
        visited[m][n] = true;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int startx, int starty){
        if (index == word.length() - 1) {
            return board[startx][starty] == word.charAt(index);
        }
        if (board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;
            for (int i = 0; i < 4; i ++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                if (inArea(newx, newy) && ! visited[newx][newy]) {
                    if (searchWord(board, word, index + 1, newx, newy)) {
                        return true;
                    }
                }
            }
            visited[startx][starty] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y <n;
    }
}
