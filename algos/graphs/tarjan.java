import java.util.*;
import java.io.*;

class tarjan { // counts strongly connected components
    int unvisited = -1;
    int id; // Give each node an id
    int sccCount; // count Sccs
    int[] ids; // ids for use in algo
    int[] scss; // scss-link, stores all cc's
    boolean[] onStack;

    Deque<Integer> stack;
    int n;
    Map<Integer, Set<Integer>> g;
    Map<Integer, Integer> scount;

    public tarjan(Map<Integer, Set<Integer>> gg) {
        id = 0;
        sccCount = 0;
        g = gg;
        n = g.size();
        ids = new int[n];
        scss = new int[n];
        onStack = new boolean[n];
        stack = new ArrayDeque<>();
        scount = new HashMap<>();
    }

    public int[] findSccs() {
        Arrays.fill(ids, unvisited);
        for (int i = 0; i < n; i++)
            if (ids[i] == unvisited)
                dfs(i);
        for (int i : scss)
            scount.put(i, scount.getOrDefault(i, 0) + 1);
        return scss;
    }

    public void dfs(int at) {
        stack.push(at);
        onStack[at] = true;
        ids[at] = scss[at] = id;
        id++;

        // Visit all neighbors, min scss-link on callback
        for (Integer to : g.get(at)) {
            if (ids[to] == unvisited)
                dfs(to);
            if (onStack[to])
                scss[at] = Math.min(scss[at], scss[to]);
        }

        // After having visited all neighbors of at
        // If we're at the start of a SCC empty the seen stack
        // Until we're back to the start of the SCC
        if (ids[at] == scss[at]) {
            for (int node = stack.pop();; node = stack.pop()) {
                onStack[node] = false;
                scss[node] = ids[at];
                if (node == at)
                    break;
            }
            sccCount++;
        }
    }
}