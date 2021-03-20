/*
 * @lc app=leetcode id=833 lang=java
 *
 * [833] Find And Replace in String
 */
import java.util.*;
import java.io.*;

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        /*
            replace(i, x, y):
                if (s.substring(i, i+x.length) == x)
                    replace x with y
            
            S = "abcd"
            replace(2, "cd", "ffff")
                S.substring(2, 2+2) = S.substring(2, 4) = "cd"
                    replace "cd" with "ffff"
            S now = "abffff"

            S = "abcd"
            replace(0, "ab", "eee")
                s.substring(0, 0+2) = S.substring(2, 2) = "ab"
                    replace "ab" with "ffff"
            S = "eeecd"
            replace(2, "ec", "ffff")
                s.substring(2, 2+2) = S.substring(2, 4) = "ec"
                    do nothing
        */

        StringBuilder str = new StringBuilder();

       Map<Integer, Integer> map = new HashMap<>(); // indexes[i] -> index for sources and target
       for (int i = 0; i < indexes.length; i++) {
           map.put(indexes[i], i);
       }

        for (int i = 0; i < S.length(); i++) {
            Integer idx = map.get(i);
            if (idx == null) {
                str.append(S.charAt(i));
                continue;
            }

            boolean equals = true;
            for (int j = i, k = 0; j < i+sources[idx].length(); j++, k++) {
                if (S.charAt(j) != sources[idx].charAt(k)) {
                    equals = false;
                    break;
                }
            }

            if (equals) {
                str.append(targets[idx]);
                i += sources[idx].length()-1;
            }
            else {
                str.append(S.charAt(i));
            }
        }        
       
        return str.toString();
    }
}
// @lc code=end

