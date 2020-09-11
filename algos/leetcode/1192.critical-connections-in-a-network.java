/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 */

// @lc code=start
import java.util.*;
import java.io.*;

class tarjan {

    private int n;
    private List<List<Integer>> graph;

    private boolean solved;
    private int sccCount, id;
    private boolean[] onStack;
    private int[] ids, low;
    private Deque<Integer> stack;

    private static final int UNVISITED = -1;

    public tarjan(List<List<Integer>> graph) {
        n = graph.size();
        this.graph = graph;
    }

    // Returns the number of strongly connected components in the graph.
    public int sccCount() {
        if (!solved)
            solve();
        return sccCount;
    }

    // Get the connected components of this graph. If two indexes
    // have the same value then they're in the same SCC.
    public int[] getSccs() {
        if (!solved)
            solve();
        return low;
    }

    public void solve() {
        if (solved)
            return;

        ids = new int[n];
        low = new int[n];
        onStack = new boolean[n];
        stack = new ArrayDeque<>();
        Arrays.fill(ids, UNVISITED);

        for (int i = 0; i < n; i++)
            if (ids[i] == UNVISITED)
                dfs(i);

        solved = true;
    }

    private void dfs(int at) {

        stack.push(at);
        onStack[at] = true;
        ids[at] = low[at] = id++;

        for (int to : graph.get(at)) {
            if (ids[to] == UNVISITED)
                dfs(to);
            if (onStack[to])
                low[at] = Math.min(low[at], low[to]);
        }

        // On recursive callback, if we're at the root node (start of SCC)
        // empty the seen stack until back to root.
        if (ids[at] == low[at]) {
            for (int node = stack.pop();; node = stack.pop()) {
                onStack[node] = false;
                low[node] = ids[at];
                if (node == at)
                    break;
            }
            sccCount++;
        }
    }
}

class Solution {
    List<List<Integer>> g;
    List<List<Integer>> ret;
    PrintWriter out = new PrintWriter(System.out, true);

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ret = new ArrayList<>();
        g = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<Integer>());
        }

        for (List<Integer> pair : connections) {
            g.get(pair.get(0)).add(pair.get(1));
            g.get(pair.get(1)).add(pair.get(0));
        }

        int[] colors = new int[n];
        boolean[] used = new boolean[n];
        int color = 0;

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                dfs(i, used, colors, color);
                color++;
            }
        }

        out.println(Arrays.toString(colors));

        return ret;
    }

    void dfs(int node, boolean[] used, int[] colors, int color) {
        used[node] = true;
        colors[node] = color;

        for (Integer next : g.get(node)) {
            if (!used[next]) {
                dfs(next, used, colors, color);
            }
        }
    }
}
// @lc code=end

/*
 * abstract
 * 
 * 5\n[[1,0],[2,0],[3,2],[4,2],[4,3],[3,0],[4,0]]
 */