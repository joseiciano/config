import java.util.*;
import java.io.*;

class LongestCommonSubstring {

    static PrintWriter out = new PrintWriter(System.out, true);

    public static String longestCommonSubstring(String a, String b) {
        int alen = a.length();
        int blen = b.length();

        int[][] dp = new int[alen + 1][blen + 1];

        // If either of the strings are empty, there is no longest common substring
        // Doesn't need to be done in java but important for algo
        for (int i = 0; i <= alen; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= blen; i++)
            dp[0][i] = 0;

        for (int i = 1; i <= alen; i++)
            for (int j = 1; j <= blen; j++)
                // If current substrings are equal, the previous (i-1)(j-1) can be concat
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;

        // The array now contains the length of the lcs, now we just want to see it
        // Find and print out the substring
        int max = 0;
        int maxi = 0;
        int maxj = 0;
        for (int i = 1; i <= alen; i++)
            for (int j = 1; j <= blen; j++)
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    maxi = i;
                    maxj = j;
                }

        int starti = 0;
        int startj = 0;
        for (int i = maxi, j = maxj; i > 0 && j > 0; i--, j--) {
            if (dp[i][j] == 0)
                break;
            starti = i;
            startj = j;
        }

        for (int i = 0; i <= alen; i++)
            out.println(Arrays.toString(dp[i]));
        out.println("LCSS OF " + a + " AND " + b + " IS " + a.substring(starti - 1, maxi));

        return a.substring(starti - 1, maxi);
    }

    public static void main(String[] args) {
        String a = "aacdefcaa";
        String b = "aacfedcaa";
        longestCommonSubstring(a, b);
    }
}