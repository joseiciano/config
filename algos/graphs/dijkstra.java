import java.util.*;
import java.io.*;

public class dijkstra {
    static PrintWriter out = new PrintWriter(System.out, true);
    static int oo = (int)1e9; // prevents overflow
    static int n; // size of graph
    static Map<Integer, List<edge>> g;

    static class edge implements Comparable<edge> {
        int loc;
        int w;

        public edge(int ll, int ww) {
            loc = ll;
            w = ww;
        }

        public int compareTo(edge e) {
            return w - e.w;
        }

        public String toString() {
            return "(" + loc + " : " + w + ")";
        }
    }

    static void init() throws Exception{
        Scanner in = new Scanner(new File("dijkstra.in"));
        n = in.nextInt();
        g = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            g.put(i, new ArrayList<>());
        }

        while (in.hasNext()) {
            int from = in.nextInt();
            int to = in.nextInt();
            int weight = in.nextInt();

            g.get(from).add(new edge(to, weight));
        }
    }

    // source to all
    static void dijkstras(int s) {
        int[] dist = new int[n]; // final lengths
        boolean[] vis = new boolean[n];
        PriorityQueue<edge> minheap = new PriorityQueue<>();

        Arrays.fill(dist, oo);
        dist[s] = 0;

        for (int i = 0; i < n; i++) {
            minheap.add(new edge(i, dist[i]));
        }

        while (!minheap.isEmpty()) {
            // Smallest distance vertex
            edge v = minheap.remove();
            if (vis[v.loc]) continue;

            vis[v.loc] = true;

            for (edge next : g.get(v.loc)) {
                if (dist[v.loc] + next.w < dist[next.loc]) {
                    dist[next.loc] = dist[v.loc] + next.w;
                    minheap.add(new edge(next.loc, dist[next.loc]));
                }
            }
        }

        out.println(Arrays.toString(dist));
    }

    // source to destination
    static int dijkstras(int s, int d) {
        boolean[] vis = new boolean[n];
        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(s, 0)); 

        while (!pq.isEmpty()) {

            edge cur = pq.poll();
            if (vis[cur.loc])
                continue;
            vis[cur.loc]  = true;

            if (cur.loc == d) return cur.w;

            for (edge next : g.get(cur.loc))
                if (!vis[next.loc])
                    pq.add(new edge(next.loc, next.w + cur.w));
        }

        return oo;
    }
    public static void main(String[] args) throws Exception {
        init();

        // out.println(dijkstras(0, 4));
        dijkstras(0);
    }
}