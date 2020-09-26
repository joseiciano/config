import java.util.*;
import java.io.*;

public class petyastrings {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        String a = in.next();
        String b = in.next();

        int res = 0;
        if (a.length() < b.length())
            res = -1;
        else if (a.length() > b.length())
            res = 1;
        else {
            for (int i = 0; i < a.length(); i++) {
                char achar = Character.toLowerCase(a.charAt(i));
                char bchar = Character.toLowerCase(b.charAt(i));

                if (achar < bchar)
                    res = -1;
                else if (achar > bchar)
                    res = 1;

                if (res != 0)
                    break;
            }
        }

        out.println(res);

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
