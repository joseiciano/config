class dijkstra {
    class edge implements Comparable<edge> {
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

    public int oo = (int) 1e9;
    public int n;
    public Map<Integer, List<edge>> g;
    public int[] dist;
    public boolean[] vis;

    public dijkstra(int n) {
        this.n = n;
        g = new HashMap<>();

        for (int i = 0; i < n; i++)
            g.put(i, new ArrayList<edge>());

        dist = new int[n];
        vis = new boolean[n];
    }

    // Add relationship between u to v with weight w
    public void addedge(int u, int v, int w) {
        g.get(u).add(new edge(u, v, w));
    }

    // Source to all
    public void dijkstras(int s) {
        dist = new int[n];
        vis = new boolean[n];
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

            for (edge next : g.get(v.v)) {
                if (dist[v.v] + next.w < dist[next.v]) {
                    dist[next.v] = dist[v.v] + next.w;
                    minheap.add(new edge(-1, next.v, dist[next.v]));
                }
            }
        }
    }

    // Source to dist
    public int dijkstras(int s, int d) {
        vis = new boolean[n];
        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(-1, s, 0));

        while (!pq.isEmpty()) {
            edge cur = pq.poll();
            if (vis[cur.v])
                continue;

            vis[cur.v] = true;

            if (cur.v == d)
                return cur.w;

            for (edge next : g.get(cur.v))
                if (!vis[next.v])
                    pq.add(new edge(-1, next.v, next.w + cur.w));
        }

        return oo;
    }
}