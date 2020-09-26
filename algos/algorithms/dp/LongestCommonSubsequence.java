import java.util.*;
import java.io.*;

public class LongestCommonSubsequence {

    public static String lcss(String a, String b) {
        int alen = a.length();
        int blen = b.length();

        int[][] dp = new int[alen + 1][blen + 1];

        // base cases, no characters? no lcss
        for (int i = 0; i <= alen; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= blen; i++)
            dp[0][i] = 0;

        for (int i = 1; i <= alen; i++)
            for (int j = 1; j <= blen; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }

        // Printing out the lcss, this is extra
        char[] str = new char[dp[alen][blen]];
        int idx = dp[alen][blen] - 1;
        int i = alen;
        int j = blen;

        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                str[idx--] = a.charAt(i - 1);
                i--;
                j--;
            }

            else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }

        System.out.println(new String(str));
        return new String(str);
    }

    public static void main(String[] args) {
        lcss("hodor", "modohodo");
    }
}