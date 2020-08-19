import java.util.*;

public class dfs {
    static int n; // number of nodes in graph
    static Map<Integer, ArrayList<Integer>> graph; // graph representation adjacency list
    static boolean[] vis; // visited array

    static void goIter(int node) {
        Deque<Integer> s = new ArrayDeque<>();
        s.offerLast(node);
        vis[node] = true;

        while (!s.isEmpty()) {
            int level = s.size();
            for (int i = 0; i < level; i++) {
                Integer curNode = s.pollLast();

                // Do all processing here

                ArrayList<Integer> neighbors = graph.get(curNode);
                for (Integer neighbor : neighbors)
                    if (!vis[neighbor]) {
                        vis[neighbor] = true;
                        s.offerLast(neighbor);
                    }

            }
        }
    }

    static void go(int node) {
        if (vis[node])
            return;

        vis[node] = true;
        ArrayList<Integer> neighbors = graph.get(node);

        for (Integer neighbor : neighbors) {
            go(neighbor);
        }
    }

    public static void main(String[] args) {
        n = 0;
        graph = new HashMap<>();

        vis = new boolean[n];
        Arrays.fill(vis, false);

        int startNode = 0;
        go(startNode);
        goIter(startNode);
    }
}