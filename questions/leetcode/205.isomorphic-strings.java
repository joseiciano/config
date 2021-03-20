
/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */
import java.util.*;
import java.io.*;

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> aToB = new HashMap<>();
        Map<Character, Character> bToA = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char d = t.charAt(i);

            if ((aToB.containsKey(c) && !bToA.containsKey(d)) || (bToA.containsKey(d) && !aToB.containsKey(c))) {
                return false;
            }

            if (aToB.containsKey(c) && bToA.containsKey(d) && aToB.get(c) != d) {
                return false;
            }
            aToB.put(c, d);
            bToA.put(d, c);
        }

        return true;
    }
}
// @lc code=end
