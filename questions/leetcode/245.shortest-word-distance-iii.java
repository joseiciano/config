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

        boolean sameword = word1.equals(word2);
        boolean ff1 = true;
        for (int i = 0; i < n; i++) {
            if (!sameword) {
                if (words[i].equals(word1)) {
                    f1 = i;
                }
                if (words[i].equals(word2)) {
                    f2 = i;
                }
            } else {
                if (words[i].equals(word1) && ff1) {
                    f1 = i;
                    ff1 = !ff1;
                } else if (words[i].equals(word2) && !ff1) {
                    f2 = i;
                    ff1 = !ff1;
                }
            }

            if (f1 > -1 && f2 > -1) {
                ret = Math.min(ret, Math.abs(f1 - f2));
            }

        }
        return ret;
    }
}
// @lc code=end
