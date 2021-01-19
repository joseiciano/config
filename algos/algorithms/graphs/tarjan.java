class tarjan { // counts strongly connected components
    private int unvisited = -1;
    private int id; // Give each node an id
    public int sccCount; // count Sccs
    private int[] ids; // ids for use in algo
    public int[] sccs; // sccs-link, stores all cc's
    private boolean[] onStack;

    private Deque<Integer> stack;
    public int n;
    public Map<Integer, List<Integer>> g;
    public Map<Integer, Integer> scount; // Count specific amount of nodes in component

    public tarjan(int n) {
        this.n = n;

        g = new HashMap<>();
        for (int i = 0; i < n; i++)
            g.put(i, new ArrayList<>());

        id = 0;
        sccCount = 0;

        ids = new int[n];
        sccs = new int[n];
        onStack = new boolean[n];
        stack = new ArrayDeque<>();
        scount = new HashMap<>();
    }

    public void addedge(int u, int v) {
        g.get(u).add(v);
    }

    public int[] findSccs() {
        Arrays.fill(ids, unvisited);
        for (int i = 0; i < n; i++)
            if (ids[i] == unvisited)
                dfs(i);
        for (int i : sccs)
            scount.put(i, scount.getOrDefault(i, 0) + 1);
        return sccs;
    }

    private void dfs(int at) {
        stack.push(at);
        onStack[at] = true;
        ids[at] = sccs[at] = id;
        id++;

        // Visit all neighbors, min sccs-link on callback
        for (Integer to : g.get(at)) {
            if (ids[to] == unvisited)
                dfs(to);
            if (onStack[to])
                sccs[at] = Math.min(sccs[at], sccs[to]);
        }

        // After having visited all neighbors of at
        // If we're at the start of a SCC empty the seen stack
        // Until we're back to the start of the SCC
        if (ids[at] == sccs[at]) {
            for (int node = stack.pop();; node = stack.pop()) {
                onStack[node] = false;
                sccs[node] = ids[at];
                if (node == at)
                    break;
            }
            sccCount++;
        }
    }
}