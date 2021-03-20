
/*
 * @lc app=leetcode id=934 lang=java
 *
 * [934] Shortest Bridge
 */
import java.util.*;
import java.io.*;

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);
    int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

    int n;
    int m;

    public int shortestBridge(int[][] A) {
        n = A.length;
        m = A[0].length;

        Deque<int[]> q = new ArrayDeque<>();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (found)
                    break;

                if (A[i][j] == 1) {
                    Deque<int[]> q2 = new ArrayDeque<>();
                    q2.offer(new int[] { i, j });
                    q.offer(new int[] { i, j, 0 });
                    A[i][j] = 2;

                    while (!q2.isEmpty()) {
                        int[] cur = q2.pollFirst();

                        for (int[] dir : dirs) {
                            int nr = cur[0] + dir[0];
                            int nc = cur[1] + dir[1];

                            if (isin(nr, nc) && A[nr][nc] == 1) {
                                A[nr][nc] = 2;
                                q2.offerLast(new int[] { nr, nc });
                                q.offerLast(new int[] { nr, nc, 0 });
                            }
                        }
                    }

                    found = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();

            if (A[cur[0]][cur[1]] == 1)
                return cur[2];

            for (int[] dir : dirs) {
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];

                if (isin(nr, nc)) {
                    if (A[nr][nc] == 1) {
                        return cur[2];
                    } else if (A[nr][nc] == 0) {
                        A[nr][nc] = A[cur[0]][cur[1]];
                        q.offerLast(new int[] { nr, nc, cur[2] + 1 });
                    }
                }
            }
        }

        return -1;
    }

    boolean isin(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}
// @lc code=end
