/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";

        int n = s.length();
        String rev = reverse(s);

        System.out.println(rev);
        int[][] dp = new int[n + 1][n + 1];

        int max = 0;
        String maxret = "";

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == max) {
                    String s1 = s.substring(i - dp[i][j], dp[i][j]);
                    String s2 = reverse(s1);
                    if (s1.equals(s2)) {
                        maxret = s1;
                    }
                }
            }
        }

        return maxret;
    }

    String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
// @lc code=end
