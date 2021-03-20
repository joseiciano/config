class graph {
    public Map<Integer, List<Integer>> g; // adjacency list
    public boolean[] vis;
    public int n;

    public graph(int n) {
        this.n = n;
        g = new HashMap<>();
        for (int i = 0; i < n; i++)
            g.put(i, new ArrayList<>());
        vis = new boolean[n];
    }

    public void addedge(int u, int v) {
        g.get(u).add(v);
    }

    public void clearvis() {
        Arrays.fill(vis, false);
    }

    // Only works on undirected graphs
    public boolean isBipartite() {
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

                for (Integer neighbor : g.get(node)) {
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

    public void dfs(int node) {
        if (vis[node])
            return;

        vis[node] = true;

        for (Integer neighbor : g.get(node)) {
            dfs(neighbor);
        }
    }

    public void bfs(int node) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(node);
        vis[node] = true;

        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                Integer cur = q.pollFirst();

                // Do all processing here

                for (Integer neighbor : g.get(cur)) {
                    if (!vis[neighbor]) {
                        vis[neighbor] = true;
                        q.offerLast(neighbor);
                    }
                }
            }
        }
    }
}