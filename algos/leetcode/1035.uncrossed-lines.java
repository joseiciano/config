/*
 * @lc app=leetcode id=1035 lang=java
 *
 * [1035] Uncrossed Lines
 */

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);
    public int maxUncrossedLines(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return 0;

        int n = A.length;
        int m = B.length;

        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i-1] == B[j-1]) 
                    dp[i][j] = 1 + dp[i-1][j-1];
                else 
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
}
// @lc code=end

