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

class firefly {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        int n = in.nextInt();
        int h = in.nextInt();

        int min = 0;
        int floor = 0;

        int[] cave = new int[n];

        for (int i = 0; i < n; i++) {
            cave[i] = in.nextInt();
        }

        int best = 1000000;
        int bestcount = 0;

        out.println(Arrays.toString(cave));

        for (int i = 1; i < h; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if ((j % 2 == 0 && cave[j] >= i) || (j % 2 == 1 && h - cave[j] < i)) {
                    cur++;
                }
            }

            if (cur < best) {
                best = cur;
                bestcount = 1;
            }

            else if (cur == best) {
                bestcount++;
            }
        }

        out.println(best + " " + bestcount);
    }
}