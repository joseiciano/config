
/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);

    int[][] memo;
    int[] denoms;

    public int change(int amount, int[] coins) {
        if (amount == 0)
            return 1;
        if (coins.length == 0)
            return 0;

        Arrays.sort(coins);
        int n = amount;
        int m = coins.length;
        int[][] dp = new int[n + 1][m + 1];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (coins[j - 1] > i)
                    dp[i][j] = dp[i][j - 1];
                else if (coins[j - 1] <= i)
                    dp[i][j] = dp[i - coins[j - 1]][j] + dp[i][j - 1];
            }
        }

        return dp[n][m];
    }

    int dpmemo(int amount, int[] coins) {
        if (amount == 0)
            return 0;

        Arrays.sort(coins);
        denoms = coins;
        memo = new int[amount + 1][coins.length + 1];
        for (int i = 0; i <= amount; i++) {
            Arrays.fill(memo[i], -1);
        }

        return go(amount, coins.length - 1);
    }

    int go(int amount, int idx) {
        if (amount == 0)
            return 1;
        if (amount < 0 || idx < 0)
            return 0;
        if (memo[amount][idx] > -1)
            return memo[amount][idx];

        int ways = 0;
        if (denoms[idx] <= amount) {
            ways += go(amount - denoms[idx], idx); // take
            ways += go(amount, idx - 1); // no take
        } else {
            ways += go(amount, idx - 1); // can't take
        }

        memo[amount][idx] = ways;
        return ways;
    }

}
// @lc code=end
