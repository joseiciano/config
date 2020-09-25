
/*
 * @lc app=leetcode id=482 lang=java
 *
 * [482] License Key Formatting
 */
import java.util.*;
import java.io.*;

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder str = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);

            if (c == '-')
                continue;

            if (temp.length() == K) {
                temp.append("-");
                str.append(temp);
                temp = new StringBuilder();
            }
            temp.append(Character.toUpperCase(c));
        }

        if (temp.length() > 0) {
            str.append(temp);
        }

        str.reverse();
        return str.toString();
    }
}
// @lc code=end
