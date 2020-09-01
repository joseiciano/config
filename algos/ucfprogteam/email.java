import java.util.*;

import sun.text.normalizer.CodePointTrie.Fast;

import java.io.*;

public class email {
    static PrintWriter out = new PrintWriter(System.out, true);
    static Map<Integer, List<Integer>> g;
    static Map<Integer, String> names;
    static int n;

    public static void main(String[] args) throws Exception {
        // FastScanner in = new FastScanner();
        FastScanner in = new FastScanner("email.in");

        int p = in.nextInt();
        int start = in.nextInt();
        g = new HashMap<>();
        names = new HashMap<>();
        for (int i = 1; i <= p; i++) {
            g.put(i, new ArrayList<>());
            names.put(i, in.next());
        }
        for (int i = 1; i <= p; i++)
            for (int first = in.nextInt(), j = 0; j < first; j++)
                g.get(i).add(in.nextInt());

    }

    static void go(int start) {
        Set<Integer> gg = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        dfs(start, vis, gg, path);

        if (gg.size() == 0)
            out.println("Safe chain email!");
        else {
            for (Integer i : gg)
                out.print(names.get(i) + " ");
            out.println();
        }
    }

    static boolean dfs(int node, Set<Integer> vis, Set<Integer> gg, List<Integer> path) {
        if (vis.contains(node)) {
            boolean flag = false;
            for (Integer n : path) {
                flag |= (n == node);
                if (flag)
                    gg.add(n);
            }
            return true;
        }

        vis.add(node);
        path.add(node);

        for (Integer next : g.get(node)) {
            dfs(next, vis, gg, path);
            if (gg.contains(node))
                gg.add(next);
        }

        vis.remove(node);
        path.remove(path.size() - 1);
        return false;
    }
}

class FastScanner {
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
}
