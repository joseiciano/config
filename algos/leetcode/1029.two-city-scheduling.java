/*
 * @lc app=leetcode id=1029 lang=java
 *
 * [1029] Two City Scheduling
 */

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);

    public int twoCitySchedCost(int[][] costs) {
        int A = costs.length >> 1;
        int B = A;

        Arrays.sort(costs, (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]));

        int ret = 0;
        for (int[] cost : costs) {
            if (A == 0) {
                B--;
                ret += cost[1];
            } else if (B == 0) {
                A--;
                ret += cost[0];
            } else if (cost[0] < cost[1]) {
                A--;
                ret += cost[0];
            } else {
                B--;
                ret += cost[1];
            }

        }

        return ret;

    }
}
// @lc code=end
