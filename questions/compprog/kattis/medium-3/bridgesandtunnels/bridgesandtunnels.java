import java.util.*;
import java.io.*;

public class bridgesandtunnels {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        int n = in.nextInt();
        unionfind dj = new unionfind(1100000);

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int k = 0;
        for (int i = 0; i < n; i++) {
            String u = in.next();
            String v = in.next();

            if (!set.contains(u)) {
                map.put(u, k);
                set.add(u);
                k++;
            }
            if (!set.contains(v)) {
                map.put(v, k);
                set.add(v);
                k++;
            }

            dj.unify(map.get(u), map.get(v));
            if (map.containsKey(u))
                out.println(dj.componentSize(map.get(u)));
            else
                out.println(dj.componentSize(map.get(v)));
        }
    }

    static class unionfind {
        int size;// ele in union find
        long[] sz; // size of each comp
        int[] id; // points to parent of i, parent[i]. if parent[i] = i, root
        int numComponents;

        public unionfind(int size) {
            this.size = numComponents = size;
            sz = new long[size];
            id = new int[size];

            for (int i = 0; i < size; i++) {
                id[i] = i; // each comp orignally links to itself
                sz[i] = 1; // each comp is originally size 1
            }
        }

        int find(int p) {
            // Find root of component/set
            if (p != id[p])
                id[p] = find(id[p]);
            return id[p];
        }

        // Checks if p and q are connected
        boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        // Returns size of component
        long componentSize(int p) {
            return sz[find(p)];
        }

        // Unions two components, p and q, together
        void unify(int p, int q) {
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

    static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String file) throws Exception {
            br = new BufferedReader(new BufferedReader(new FileReader(file)));
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
