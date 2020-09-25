
/*
 * @lc app=leetcode id=694 lang=java
 *
 * [694] Number of Distinct Islands
 */
import java.util.*;
import java.io.*;

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);
    int n;
    int m;
    Set<String> islands;
    int[][] dirs = { { 0, -1, 1 }, { 0, 1, 2 }, { -1, 0, 3 }, { 1, 0, 4 } };

    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        n = grid.length;
        m = grid[0].length;
        islands = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder str = new StringBuilder();
                    dfs(grid, i, j, str);
                    String s = str.toString();
                    islands.add(s);
                }
            }
        }

        return islands.size();
    }

    void dfs(int[][] grid, int i, int j, StringBuilder str) {
        if (!isin(i, j) || grid[i][j] != 1)
            return;

        grid[i][j] = 0;
        for (int[] dir : dirs) {
            str.append(dir[2]);
            dfs(grid, i + dir[0], j + dir[1], str);
        }

    }

    boolean isin(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}
// @lc code=end
