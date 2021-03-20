
/*
 * @lc app=leetcode id=975 lang=java
 *
 * [975] Odd Even Jump
 */
import java.util.*;
import java.io.*;

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);

    public int oddEvenJumps(int[] A) {
        int n = A.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);

        boolean even[] = new boolean[n];
        boolean odd[] = new boolean[n];
        even[n - 1] = odd[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            Map.Entry oddJump = map.ceilingEntry(A[i]);
            Map.Entry evenJump = map.floorEntry(A[i]);

            if (oddJump != null)
                odd[i] = even[(int) oddJump.getValue()];

            if (evenJump != null)
                even[i] = odd[(int) evenJump.getValue()];

            map.put(A[i], i);
        }

        int res = 0;
        for (boolean b : odd)
            res += b ? 1 : 0;

        return res;
    }
}
// @lc code=end
