import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/350233/Google-or-Summer-Intern-OA-2019-or-Decreasing-Subsequences
public class DecreasingSubsequences {
    static PrintWriter out = new PrintWriter(System.out, true);

    static int solve(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums[i - 1] < nums[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][n];
    }

    public static void main(String[] args) throws Exception {
        int[] in = new int[] { 5, 2, 4, 3, 1, 6 };
        out.println(solve(in)); // 3

        in = new int[] { 2, 9, 12, 13, 4, 7, 6, 5, 10 };
        out.println(solve(in)); // 4

        in = new int[] { 1, 1, 1 };
        out.println(solve(in)); // 1
    }
}