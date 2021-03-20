
/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */
import java.util.*;
import java.io.*;

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return null;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int lo = 0;
        int hi = 0;

        for (; hi < k - 1; hi++)
            pq.offer(nums[hi]);

        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; hi < nums.length; hi++, lo++, i++) {
            pq.offer(nums[hi]);
            ret[i] = pq.peek();
            pq.remove(nums[lo]);
        }

        return ret;

    }
}
// @lc code=end
