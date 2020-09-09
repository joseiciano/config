/*
 * @lc app=leetcode id=245 lang=java
 *
 * [245] Shortest Word Distance III
 */

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);

    public int shortestWordDistance(String[] words, String word1, String word2) {
        int ret = Integer.MAX_VALUE;
        int n = words.length;
        int f1 = -1;
        int f2 = -1;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(word1)) {
                if (f2 == -1)
                    f1 = i;
            }
            if (words[i].equals(word2)) {
                if (i != f1)
                    f2 = i;
            }

            if (f1 > 0 && f2 > 0) {
                ret = Math.min(ret, Math.abs(f1 - f2));
            }
        }

        return ret;
    }
}
// @lc code=end
