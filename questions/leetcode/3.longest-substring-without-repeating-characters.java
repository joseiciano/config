
/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
import java.util.*;
import java.io.*;

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int i = 0;
        int j = 0;

        for (; j <= s.length(); j++) {
            while (hasRepeating(map)) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) <= 0)
                    map.remove(s.charAt(i));

                i++;
            }

            if (j < s.length())
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            max = Math.max(max, j - i);
        }

        return max;
    }

    boolean hasRepeating(Map<Character, Integer> freq) {
        for (Integer i : freq.values())
            if (i > 1)
                return true;
        return false;
    }
}
// @lc code=end
