/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 */

import java.util.*;
import java.io.*;

// @lc code=start
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int n = N;
        ArrayList<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<Integer>();

        for (int[] edge : dislikes) {
            g[edge[0] - 1].add(edge[1] - 1);
            g[edge[1] - 1].add(edge[0] - 1);
        }

        int[] colors = new int[n];
        int red = 1;
        int blue = 2;

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (colors[i] > 0)
                continue;

            q.addLast(i);
            colors[i] = red;

            while (!q.isEmpty()) {
                int cur = q.pollFirst();

                for (Integer next : g[cur]) {
                    if (colors[next] > 0 && colors[next] == colors[cur]) {
                        return false;
                    } else {
                        colors[next] = (colors[cur] == red) ? blue : red;
                        q.offerLast(next);
                    }
                }
            }
        }

        return true;
    }
}
// @lc code=end
