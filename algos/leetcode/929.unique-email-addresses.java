
/*
 * @lc app=leetcode id=929 lang=java
 *
 * [929] Unique Email Addresses
 */
import java.util.*;
import java.io.*;

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);

    public int numUniqueEmails(String[] emails) {
        Set<String> valid = new HashSet<>();

        for (String email : emails) {
            String[] split = email.split("@");

            String local = split[0];
            String domain = split[1];

            StringBuilder newLocal = new StringBuilder();
            for (char c : local.toCharArray()) {
                if (c == '.')
                    continue;
                if (c == '+')
                    break;
                newLocal.append(c);
            }

            newLocal.append("@");
            newLocal.append(domain);
            valid.add(newLocal.toString());
        }

        return valid.size();
    }
}
// @lc code=end
