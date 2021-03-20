/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

 import java.util.*;
 import java.io.*;
 
// @lc code=start
class Solution {
    static Map<Integer, List<Integer>> g;
    static int n;
    static int[] inDegree;

    static PrintWriter out = new PrintWriter(System.out, true);
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        n = numCourses;
        g = new HashMap<>();
        inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            g.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            g.get(prereq[1]).add(prereq[0]);
            inDegree[prereq[0]]++;
        }

        int[] top = getTop();

        return top == null ? new int[0] : top;

    }

    static int[] getTop() {
        int[] res = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                pq.add(i);
        }

        for (int i = 0; i < n; i++) {
            if (pq.size() == 0)
                return null;

            res[i] = pq.poll();
            for (Integer next : g.get(res[i])) {
                inDegree[next]--;
                if (inDegree[next] == 0)
                pq.offer(next);
            }
        }

        return res;
    }
}
// @lc code=end

