import java.util.*;
import java.io.*;

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

public class mind {
    static PrintWriter out = new PrintWriter(System.out, true);

    static class pair {
        int p;
        int c;

        public pair(int pp, int cc) {
            p = pp;
            c = cc;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        int p = in.nextInt();
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.c - b.c);

        for (int i = 0; i < p; i++) {
            int c = in.nextInt();
            for (int j = 0; j < c; j++) {
                pq.offer(new pair(i, in.nextInt()));
            }
        }

        while (!pq.isEmpty()) {
            out.print((char) (pq.poll().p + 'A'));
        }

        out.println();

    }
}