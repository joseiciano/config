/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int lo = 0;
        int hi = n - 1;
        int max = 0;

        while (lo < hi) {
            int h = Math.min(height[lo], height[hi]);
            max = Math.max(h * (hi - lo), max);

            if (height[lo] < height[hi])
                lo++;
            else
                hi--;
        }

        return max;
    }
}
// @lc code=end
