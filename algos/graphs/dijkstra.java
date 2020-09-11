import java.util.*;
import java.io.*;

public class dijkstra {
    static PrintWriter out = new PrintWriter(System.out, true);
    static int oo = (int) 1e9; // prevents overflow
    static int n; // size of graph
    static List<edge>[] g;

    static class edge implements Comparable<edge> {
        int u;
        int v;
        int w;

        public edge(int uu, int vv, int ww) {
            u = uu;
            v = vv;
            w = ww;
        }

        public int compareTo(edge e) {
            return w - e.w;
        }

        public String toString() {
            return "(" + v + ": " + w + ")";
        }
    }

    static void init() throws Exception {
        Scanner in = new Scanner(new File("dijkstra.in"));
        n = in.nextInt();
        g = new List[n];

        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<edge>();

        while (in.hasNext()) {
            int from = in.nextInt();
            int to = in.nextInt();
            int weight = in.nextInt();

            g[from].add(new edge(from, to, weight));
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
            minheap.add(new edge(-1, i, dist[i]));
        }

        while (!minheap.isEmpty()) {
            // Smallest distance vertex
            edge v = minheap.poll();
            if (vis[v.v])
                continue;

            vis[v.v] = true;

            for (edge next : g[v.v]) {
                if (dist[v.v] + next.w < dist[next.v]) {
                    dist[next.v] = dist[v.v] + next.w;
                    minheap.add(new edge(-1, next.v, dist[next.v]));
                }
            }
        }

        out.println(Arrays.toString(dist));
    }

    // source to destination
    static int dijkstras(int s, int d) {
        boolean[] vis = new boolean[n];
        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(-1, s, 0));

        while (!pq.isEmpty()) {
            edge cur = pq.poll();
            if (vis[cur.v])
                continue;

            vis[cur.v] = true;

            if (cur.v == d)
                return cur.w;

            for (edge next : g[cur.v])
                if (!vis[next.v])
                    pq.add(new edge(-1, next.v, next.w + cur.w));
        }

        return oo;
    }

    public static void main(String[] args) throws Exception {
        init();

        // out.println(dijkstras(0, 4));
        dijkstras(0);
    }
}