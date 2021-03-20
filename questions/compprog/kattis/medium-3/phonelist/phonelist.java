import java.util.*;
import java.io.*;

public class phonelist {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();

            // String[] number = new String[n];
            // for (int i = 0; i < n; i++)
            // number[i] = in.nextLine();

            // Arrays.sort(number);
            // boolean flag = false;
            // for (int i = 0; i < n - 1; i++) {
            // flag |= isprefix(number[i], number[i + 1]);
            // }
            String[] phonebook = new String[n];
            for (int i = 0; i < n; i++)
                phonebook[i] = in.nextLine();

            Arrays.sort(phonebook);

            tri guy = new tri();
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                flag |= guy.insert(phonebook[i]);
            }

            if (flag)
                out.println("NO");
            else
                out.println("YES");
        }
    }

    static boolean isprefix(String a, String b) {
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                return false;
        }
        return true;
    }

    static class tri {
        trinode root;

        public tri() {
            root = new trinode('#');
        }

        boolean insert(String s) {
            trinode cur = root;
            boolean flag = false;

            for (char c : s.toCharArray()) {
                if (cur.children[c - '0'] == null)
                    cur.children[c - '0'] = new trinode(c);

                cur = cur.children[c - '0'];
                flag |= cur.isword;
            }
            cur.isword = true;
            return flag;
        }
    }

    static class trinode {
        char c;
        trinode[] children;
        boolean isword;

        public trinode(char c) {
            this.c = c;
            children = new trinode[10];
            isword = false;
        }
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
