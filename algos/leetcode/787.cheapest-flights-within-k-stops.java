/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

import java.util.*;
import java.io.*;

// @lc code=start
class Solution {
    class triplet {
        int w; // weight/cost
        int s; // stops

        public triplet(int ww, int ss) {
            w = ww;
            s = ss;
        }
    }

    class pair {
        int dst; // destination
        int w; // weight/cost
        int s; // stops

        public pair(int dd, int ww) {
            dst = dd;
            w = ww;
            s = 0;
        }

        public String toString() {
            return dst + ": " + w;
        }
    }

    PrintWriter out = new PrintWriter(System.out, true);

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List[] g = new List[n];

        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<pair>();

        for (int[] flight : flights) {
            g[flight[0]].add(new pair(flight[1], flight[2]));
        }

        ArrayDeque<pair> q = new ArrayDeque<>();
        for (pair start : (List<pair>) g[src])
            q.offerLast(start);

        return 0;
    }
}
// @lc code=end
