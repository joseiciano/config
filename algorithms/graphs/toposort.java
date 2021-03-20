public class toposort {
    public int n;
    public Map<Integer, List<Integer>> g;
    public Map<Integer, Integer> inedges;

    public toposort(int n) {
        this.n = n;
        g = new HashMap<>();
        inedges = new HashMap<>();

        for (int i = 0; i < n; i++) {
            g.put(i, new ArrayList<>());
            inedges.put(i, 0);
        }
    }

    public void addedge(int u, int v) {
        g.get(u).add(v);
        inedges.put(v, inedges.get(v) + 1);
    }

    public int[] topsort() {
        int[] res = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            if (inedges.get(i) == 0)
                pq.add(0);

        for (int i = 0; i < n; i++) {
            if (pq.size() == 0) // no topsort possilble
                return new int[0];

            res[i] = pq.poll();

            for (Integer next : g.get(res[i])) {
                inedges.put(next, inedges.get(next) - 1); // remove inedge

                if (inedges.get(next) == 0)
                    pq.offer(next);
            }
        }

        return res;
    }
}
