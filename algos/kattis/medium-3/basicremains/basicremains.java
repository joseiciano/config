import java.util.*;
import java.io.*;
import java.math.*;

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

class basicremains {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        int b = in.nextInt();

        while (b != 0) {

            BigInteger p = new BigInteger(in.next(), b);
            BigInteger m = new BigInteger(in.next(), b);

            if (p.equals(BigInteger.ZERO))
                out.println("0");
            else if (m.equals(BigInteger.ZERO))
                out.println(p.toString());
            else {
                BigInteger base10 = new BigInteger(p.toString(10)).mod(new BigInteger(m.toString(10)));
                out.println(base10.toString(b));
            }

            b = in.nextInt();
        }
    }
}