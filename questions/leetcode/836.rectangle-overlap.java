/*
 * @lc app=leetcode id=836 lang=java
 *
 * [836] Rectangle Overlap
 */

import java.util.*;
import java.io.*;

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] || rec1[3] <= rec2[1] || rec1[0] >= rec2[2] || rec1[1] >= rec2[3]);
    }
}
// @lc code=end
