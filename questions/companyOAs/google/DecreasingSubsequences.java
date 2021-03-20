import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/350233/Google-or-Summer-Intern-OA-2019-or-Decreasing-Subsequences
public class DecreasingSubsequences {
    static PrintWriter out = new PrintWriter(System.out, true);

    static int binsearch(int[] nums, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);

            if (nums[mid] <= target)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }

    static int solvebin(int[] nums) {
        int n = nums.length;
        int[] piles = new int[n];
        int size = 0;

        for (int num : nums) {
            int idx = binsearch(piles, 0, size, num);
            piles[idx] = num;
            if (idx == size)
                size++;
        }

        return size;
    }

    static int solve(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = 1;
        int ret = 0;

        for (int i = 1; i < n; i++) {
            int max = 0;

            for (int j = 0; j < i; j++)
                if (dp[j] > max && nums[j] < nums[i])
                    max = dp[j];

            dp[i] = max + 1;
            ret = Math.max(ret, dp[i]);
        }

        return ret;
    }

    public static void main(String[] args) throws Exception {
        int[] in = new int[] { 5, 2, 4, 3, 1, 6 };
        out.println(solvebin(in)); // 3

        // in = new int[] { 2, 9, 12, 13, 4, 7, 6, 5, 10 };
        // out.println(solve(in)); // 4

        // in = new int[] { 1, 1, 1 };
        // out.println(solve(in)); // 1
    }
}