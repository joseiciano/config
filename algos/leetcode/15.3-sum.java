/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

import java.util.*;
import java.io.*;

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Set<List<Integer>> vis = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int lo = i + 1;
            int hi = n - 1;
            int sum = 0 - nums[i];

            while (lo < hi) {
                if (nums[lo] + nums[hi] == sum) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[lo], nums[hi]);
                    List<Integer> temp2 = Arrays.asList(nums[i], nums[lo], nums[hi]);
                    Collections.sort(temp2);

                    // Make sure to not add duplicate triplets
                    if (!vis.contains(temp2)) {
                        ret.add(temp);
                        vis.add(temp2);
                    }

                    lo++;
                    hi--;
                } else if (nums[lo] + nums[hi] > sum)
                    hi--;
                else if (nums[lo] + nums[hi] < sum)
                    lo++;
            }
        }

        return ret;
    }
}
// @lc code=end
