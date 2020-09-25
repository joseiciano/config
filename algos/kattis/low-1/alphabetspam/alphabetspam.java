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

public class alphabetspam {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        String s = in.nextLine();

        int whitespace = 0;
        int uppercase = 0;
        int lowercase = 0;
        int symbols = 0;
        int total = s.length();

        for (char c : s.toCharArray()) {
            if (c == '_')
                whitespace++;
            else if (Character.isLetter(c)) {
                if (Character.isUpperCase(c))
                    uppercase++;
                else
                    lowercase++;
            } else
                symbols++;
        }

        f(whitespace, total);
        f(lowercase, total);
        f(uppercase, total);
        f(symbols, total);
    }

    static void f(int s, int t) {
        double res = (double) s / (double) t;
        out.printf("%.16f\n", res);
    }

}
