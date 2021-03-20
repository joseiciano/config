import java.util.*;
import java.io.*;

public class kruskals {
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

    class edge implements Comparable<edge> {
        int from;
        int to;
        int cost;

        public edge(int f, int t, int c) {
            from = f;
            to = t;
            cost = c;
        }

        public int compareTo(edge e) {
            return cost - e.cost;
        }
    }

    Long kruskalMST(edge[] edges, int n) {
        if (edges == null)
            return null;

        long sum = 0L;
        Arrays.sort(edges);
        unionfind dj = new unionfind(n);

        for (edge e : edges) {
            // Skip this edge, would create a cycle
            if (dj.connected(e.from, e.to))
                continue;

            // Include edge
            dj.unify(e.from, e.to);
            sum += e.cost;

            // Early break: found a MST that includes all nodes
            if (dj.componentSize(0) == n)
                break;
        }

        // Make sure there is a MST with all nodes
        if (dj.componentSize(0) != n)
            return null;

        return sum;
    }
}
