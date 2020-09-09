import java.util.*;
import java.io.*;

class bills {
    static PrintWriter out = new PrintWriter(System.out, true);

    static class pair implements Comparable<pair> {
        int denom;
        int amount;
        int money;

        public pair(int d, int a) {
            denom = d;
            amount = a;
            money = d * a;
        }

        public int compareTo(pair p) {
            return (money != p.money) ? p.money - money : amount - p.amount;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        int[] denoms = new int[] { 1, 5, 10, 20, 50, 100 };
        pair[] wallet = new pair[6];
        for (int i = 0; i < 6; i++)
            wallet[i] = new pair(denoms[i], in.nextInt());

        Arrays.sort(wallet);

        out.println(wallet[0].denom);
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
