import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        ArrayList<Integer>[] g = init(graph, n);

        Deque<Integer> q = new ArrayDeque<>();
        int[] colors = new int[n];
        int red = 1;
        int blue = 2;

        for (int i = 0; i < n; i++) {
            if (colors[i] > 0)
                continue;

            q.offerLast(i);
            colors[i] = red;
            while (!q.isEmpty()) {
                int cur = q.pollFirst();

                for (Integer neighbor : (ArrayList<Integer>) g[cur]) {
                    if (colors[neighbor] > 0) {
                        if (colors[neighbor] == colors[cur])
                            return false;
                    } else {
                        colors[neighbor] = (colors[cur] == red ? blue : red);
                        q.offerLast(neighbor);
                    }

                }
            }
        }

        return true;
    }

    ArrayList<Integer>[] init(int[][] graph, int n) {
        ArrayList<Integer>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            for (int edge : graph[i]) {
                g[i].add(edge);
            }
        }

        return g;
    }
}
// @lc code=end
