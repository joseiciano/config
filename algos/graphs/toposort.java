import java.util.*;
import java.io.*;

// https://leetcode.com/problems/course-schedule-ii/submissions/

public class toposort {
    static Map<Integer, List<Integer>> adjList;
    static Map<Integer, Integer> inedges;
    static int n;

    static void initGraph() throws Exception {
        Scanner in = new Scanner(new File("graph.in"));
        adjList = new HashMap<>();
        inedges = new HashMap<>();
        n = in.nextInt();

        for (int i = 0; i < n; i++)
            inedges.put(i, 0);

        while (in.hasNext()) {
            int u = in.nextInt();
            int v = in.nextInt();

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());

            adjList.get(u).add(v);
            inedges.put(v, inedges.get(v) + 1);
        }
    }

    static int[] topsort(Map<Integer, List<Integer>> adjList, int n) {
        int[] res = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (inedges.get(i) == 0)
                pq.add(0);
        }

        for (int i = 0; i < n; i++) {
            if (pq.size() == 0) // no topsort possilble
                return new int[0];

            res[i] = pq.poll();

            for (Integer next : adjList.get(res[i])) {
                inedges.put(next, inedges.get(next) - 1); // remove inedge

                if (inedges.get(next) == 0)
                    pq.offer(next);
            }
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        initGraph();

        // System.out.println(isBipartite(adjList, n));
    }
}
