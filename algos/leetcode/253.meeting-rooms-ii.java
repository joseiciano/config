/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

 import java.util.*;
 import java.io.*;

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1] - b[1]);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int ret = 1;

        for (int[] erval : intervals) {
            q.offer(erval);
        }

        int[] running = q.poll();
        out.println("START " + Arrays.toString(running));
        while (!q.isEmpty()) {
            int[] next = q.poll();
            out.println("RUNNING " + Arrays.toString(running) + " CURRENT " + Arrays.toString(next));
            if (next[1] < running[0]) {
                ret++;
            }
            running = next;
        }

        
        return ret;
    }
}
// @lc code=end

