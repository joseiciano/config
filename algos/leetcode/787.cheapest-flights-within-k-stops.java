/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

import java.util.*;
import java.io.*;

// @lc code=start
class Solution {

    class pair implements Comparable<pair>{
        int loc;
        int w;
        int k;

        public pair (int l, int ww, int kk) {
            loc = l;
            w = ww;
            k = kk;
        }

        public int compareTo(pair p) {
            return w - p.w;
        }
        
        public String toString() {
            return loc + ": " + w + " in " + k + " stops";
        }
    }

    PrintWriter out = new PrintWriter(System.out, true);

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<pair>> g = new HashMap<>();

        for (int i = 0; i < n; i++) {
            g.put(i, new ArrayList<>());
        }

        for (int[] flight : flights) {
            g.get(flight[0]).add(new pair(flight[1], flight[2], 0));
        }

        PriorityQueue<pair> q = new PriorityQueue<>();    
        for (pair start : g.get(src))
            q.add(start);

        while (!q.isEmpty()) {
            pair cur = q.poll();

            if (cur.loc == dst) {
                return cur.w;
            }

            for (pair next : g.get(cur.loc)) {
                if (cur.k + 1 <= K)
                    q.offer(new pair(next.loc, next.w + cur.w, cur.k + 1));
            }
        }

        return -1;
    }
}


// @lc code=end
