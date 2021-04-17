import java.util.*;
import java.io.*;

public class reversort {
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

        int[] nextArray(int n) {
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }

            return arr;
        }
    }

    static final PrintWriter out = new PrintWriter(System.out, true);
    // static final FastScanner in = new FastScanner(reversort.txt);
    static final int oo = (int) 1e9;
    static final int MOD = (int) 1e9 + 7;
    static final FastScanner in = new FastScanner();

    public static void main(String[] args) throws Exception {
        int te = in.nextInt();

        for (int t = 1; t <= te; t++) {
            // out.print("Case #" + t + ": ");
            solve();
        }
    }

    static void solve() throws Exception {
        int y = 0;

        int n = in.nextInt();
        int[] arr = in.nextArray(n);

        for (int i = 0; i < n - 1; i++) {
            int j = 0;
            for (j = i; j < n - 1; j++) {
                if (arr[j] == (i + 1))
                    break;
            }

            y += reverse(arr, i, j);
            // out.println(Arrays.toString(arr));
        }

        out.println(y);
    }

    static int reverse(int[] a, int s, int e) {
        int i = s;
        int j = e;
        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            i++;
            j--;
        }

        return e - s + 1;
    }

}