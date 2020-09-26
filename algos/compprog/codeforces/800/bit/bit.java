import java.util.*;
import java.io.*;

public class bit {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        int x = 0;
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            String op = in.nextLine();

            if (op.charAt(0) == '+' || op.charAt(2) == '+')
                x++;
            else
                x--;
        }
        out.println(x);
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
