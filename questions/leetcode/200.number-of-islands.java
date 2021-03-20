/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

import java.util.*;
import java.io.*;

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);
    int n;
    int m;
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int count = 0;
        n = grid.length;
        m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    void print(char[][] grid) {
        for (char[] row : grid)
            out.println(Arrays.toString(row));
        out.println();
    }

    void dfs(char[][] grid, int i, int j) {
        if (!isin(i, j) || grid[i][j] != '1')
            return;

        grid[i][j] = '0';
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }

    boolean isin(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}
// @lc code=end
