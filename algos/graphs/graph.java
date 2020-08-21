import java.util.*;
import java.io.*;

class graph {
    static Map<Integer, List<Integer>> adjList;
    static int n;

    static void initGraph() throws Exception {
        Scanner in = new Scanner(new File("graph.in"));
        adjList = new HashMap<>();
        n = in.nextInt();

        while (in.hasNext()) {
            int u = in.nextInt();
            int v = in.nextInt();

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    static boolean isBipartite(Map<Integer, List<Integer>> adjList, int n) {
        int[] colors = new int[n];
        int red = 1;
        int blue = 2;

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (colors[i] > 0)
                continue;

            queue.addLast(i);
            colors[i] = red;

            while (!queue.isEmpty()) {
                int node = queue.pollFirst();

                for (Integer neighbor : adjList.get(node)) {
                    // If two connecting nodes are the same color, this graph is not bipartite
                    if (colors[neighbor] > 0) {
                        if (colors[neighbor] == colors[node])
                            return false;
                    }
                    // Otherwise, color the neighbor and enqueue it
                    else {
                        colors[neighbor] = (colors[node] == red) ? blue : red;
                        queue.addLast(neighbor);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        initGraph();

        System.out.println(isBipartite(adjList, n));
    }
}