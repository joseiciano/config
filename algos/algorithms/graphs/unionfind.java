class unionfind {
    public int size;// ele in union find
    public int[] sz; // size of each comp
    public int[] id; // points to parent of i, parent[i]. if parent[i] = i, root
    public int numComponents;

    public unionfind(int size) {
        this.size = numComponents = size;
        sz = new int[size];
        id = new int[size];

        for (int i = 0; i < size; i++) {
            id[i] = i; // each comp orignally links to itself
            sz[i] = 1; // each comp is originally size 1
        }
    }

    private int find(int p) {
        // Find root of component/set
        int root = p;
        while (root != id[root])
            root = id[root];

        // Path compression
        while (id[p] != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }

        return root;
    }

    // checks if p and q are connected
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // Returns size of component
    public int componentSize(int p) {
        return sz[find(p)];
    }

    public void unify(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);

        // Elements already in the same component
        if (root1 == root2)
            return;

        if (sz[root1] < sz[root2]) {
            sz[root2] += sz[root1];
            id[root1] = root2;
        } else {
            sz[root1] += sz[root2];
            id[root2] = root1;
        }

        // We got rid of one component
        numComponents--;
    }
}