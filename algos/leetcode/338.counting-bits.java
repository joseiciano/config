import java.util.Arrays;

/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    public int[] countBits(int num) {
        // return brute(num);
        // return fancy(num);
        return fancier(num);
    }

    int[] fancier(int num) {
        int[] dp = new int[num + 1];

        for (int i = 1; i <= num; i++)
            dp[i] = dp[i / 2] + ((i % 2 == 1) ? 1 : 0);
        return dp;
    }

    int[] fancy(int num) {
        int[] dp = new int[num + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = num; i >= 0; i--) {
            int curnum = i;
            int sum = 0;

            while (curnum > 0) {
                if (dp[curnum >> 1] > -1) {
                    sum += dp[curnum >> 1];
                    if (curnum % 2 == 1)
                        sum += 1;
                    break;
                }

                if ((curnum & 1) > 0)
                    sum++;
                curnum >>= 1;
            }

            dp[i] = sum;
        }
        return dp;
    }

    int[] brute(int num) {
        int[] ret = new int[num + 1];

        for (int i = 1; i <= num; i++)
            ret[i] = count(i);

        return ret;
    }

    int count(int num) {
        int ret = 0;

        for (; num > 0; num >>= 1) {
            if ((num & 1) > 0)
                ret++;
        }
        return ret;
    }
}
// @lc code=end
