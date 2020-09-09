import java.util.*;
import java.io.*;

public class fish {
    static PrintWriter out = new PrintWriter(System.out, true);

    static class pair implements Comparable<pair> {
        int x;
        int y;

        public pair(int xx, int yy) {
            x = xx;
            y = yy;
        }

        public int compareTo(pair p) {
            return (int) (Math.sqrt(x * x + y * y) - Math.sqrt(p.x * p.x + p.y * p.y));
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    static long diff(pair a, pair b) {
        return (long) Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner("fish07.in");

        int r = in.nextInt();
        long d = 2 * r;
        int n = in.nextInt();

        pair[] p = new pair[n];

        for (int i = 0; i < n; i++) {
            p[i] = new pair(in.nextInt(), in.nextInt());
        }

        Arrays.sort(p);

        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        long max = 1;

        for (int i = 1; i < n; i++) {
            int j = 0;
            for (; j < i; j++) {
                long dd = diff(p[i], p[j]);

                if (dd > d)
                    break;

                dp[i] = Math.max(dp[i], 1 + dp[j]);
                if (dp[i] > max)
                    max = dp[i];
            }
        }

        // out.println(Arrays.toString(p));
        out.println(Arrays.toString(dp));
        out.println(max);
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
