/*
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 */

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] += (nums[i] == 1) ? 1 : -1;
        }

        int lo = 0;
        int hi = n-1;

        while (lo < hi) {
            if (dp[lo] == dp[hi]) 
                return hi - lo + 1;
            if (dp[lo] > dp[hi])
                hi--;
            else 
                lo++;
        }
        return 0;
    }
}
// @lc code=end

