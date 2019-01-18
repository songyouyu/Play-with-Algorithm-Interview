/**
 * leetcode 200
 * @author youyusong
 * @date 2018/8/29
 */
public class Solution {

    private int m, n;
    private boolean[][] visited;
    private int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        // 行
        m = grid.length;
        // 列
        n = grid[0].length;

        visited = new boolean[m][n];

        int res = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == '1' && ! visited[i][j]) {
                    dfs(grid, i, j);
                    res ++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i ++) {
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if (inArea(newx, newy) && ! visited[newx][newy]) {
                if (grid[newx][newy] == '1') {
                    dfs(grid, newx, newy);
                }
            }
        }

        return;
    }

    private boolean inArea(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
