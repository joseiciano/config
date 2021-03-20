import java.util.*;
import java.io.*;

public class capitalization {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        String s = in.next();

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0)
                str.append(Character.toUpperCase(s.charAt(i)));
            else
                str.append(Character.toUpperCase(s.charAt(i)));
        }
        out.println(str.toString());
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
