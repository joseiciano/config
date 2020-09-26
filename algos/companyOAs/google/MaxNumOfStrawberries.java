import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/396646/
// modified knapsack problem

public class MaxNumOfStrawberries {
    static PrintWriter out = new PrintWriter(System.out, true);

    static int res;

    static int solve(int[] arr, int cap) {
        res = 0;

        int[][] memo = new int[arr.length + 1][cap + 1];
        for (int i = 0; i < arr.length; i++)
            Arrays.fill(memo[i], -1);

        for (int i = 0; i < arr.length; i++)
            dfs(arr, i, arr[i], cap, memo);
        return res;
    }

    static void dfs(int[] arr, int k, int tmp, int cap, int[][] memo) {
        if (tmp >= cap)
            return;

        if (memo[k][cap] > -1)
            return;

        res = Math.max(tmp, res);
        for (int i = 2; i < arr.length; i++)
            for (int j = k; j + i < arr.length; j++)
                dfs(arr, i + j, tmp + arr[i + j], cap, memo);

        memo[k][cap] = res;
    }

    static int solvedp(int[] arr, int cap) {
        int n = arr.length;
        int[][] dp = new int[n + 2][cap + 1]; // goes to n+2 because we have to skip 2 days

        for (int i = 2; i <= n + 1; i++) {
            for (int j = 1; j <= cap; j++) {
                if (arr[i - 2] <= j)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - arr[i - 2]] + arr[i - 2]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n + 1][cap];
    }

    public static void main(String[] args) throws Exception {
        int maxstrawberries = 100;
        int[] arr = new int[] { 50, 10, 20, 30, 40 };
        // out.println(solve(arr, n, maxstrawberries));
        out.println(solvedp(arr, maxstrawberries));
    }
}