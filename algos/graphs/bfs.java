import java.util.*;

public class bfs {
    static int n; // number of nodes in graph
    static Map<Integer, ArrayList<Integer>> graph; // graph representation adjacency list
    static boolean[] vis; // visited array

    static void go(int node) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(node);
        vis[node] = true;

        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                Integer cur = q.pollFirst();

                // Do all processing here

                ArrayList<Integer> neighbors = graph.get(cur);
                for (Integer neighbor : neighbors) {
                    if (!vis[neighbor]) {
                        vis[neighbor] = true;
                        q.offerLast(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}