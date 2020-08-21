/*
 * @lc app=leetcode id=252 lang=java
 *
 * [252] Meeting Rooms
 */

 import java.util.*;
 import java.io.*;
 
// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

        for (int prev = 0, cur = 1; cur < intervals.length; cur++) {
            if (intervals[cur][0] < intervals[prev][1])
                return false;
            prev = cur;
        }

        return true;
    }
}
// @lc code=end

