
/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 */
import java.util.*;
import java.io.*;

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);

    public int totalFruit(int[] tree) {
        int n = tree.length;

        int i = 0;
        int j = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (; j <= n; j++) {
            while (map.size() > 2) {
                map.put(tree[i], map.get(tree[i]) - 1);
                if (map.get(tree[i]) <= 0)
                    map.remove(tree[i]);
                i++;
            }

            if (j < n)
                map.put(tree[j], map.getOrDefault(tree[j], 0) + 1);
            max = Math.max(max, j - i);
        }

        return max;
    }
}
// @lc code=end
