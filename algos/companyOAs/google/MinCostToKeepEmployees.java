import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/397339/
public class MinCostToKeepEmployees {
    static PrintWriter out = new PrintWriter(System.out, true);

    static int go(int prev, int hire, int salary, int severance, int idx, int[] emps, int[][] dp) {
        if (dp[idx][prev] == -1) {
            if (idx == emps.length) {
                dp[idx][prev] = 0;
            } else {
                int cost = 0;
                if (emps[idx] >= prev) {
                    cost += (emps[idx] - prev) * hire + emps[idx] * salary
                            + go(emps[idx], hire, salary, severance, idx + 1, emps, dp);
                } else {
                    int cur = Integer.MAX_VALUE;
                    // try everything
                    for (int i = emps[idx]; i <= prev; i++) {
                        // hire emp i, severance cost + cur month salary
                        int curcost = (prev - i) * severance + i * salary
                                + go(i, hire, salary, severance, idx + 1, emps, dp);
                        cur = Math.min(cur, curcost);
                    }

                    cost += cur;
                }
                dp[idx][prev] = cost;
            }
        }

        return dp[idx][prev];
    }

    static int solve(int hire, int salary, int severance, int[] emps) {
        int n = emps.length;
        int[][] dp = new int[n + 1][51];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);

        return go(0, hire, salary, severance, 0, emps, dp);
    }

    public static void main(String[] args) throws Exception {
        int[] employees = new int[] { 14, 10, 11 };
        out.println(solve(5, 6, 7, employees)); // 307
    }
}