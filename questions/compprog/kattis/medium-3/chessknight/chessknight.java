import java.util.*;
import java.io.*;

public class chessknight {
    static PrintWriter out = new PrintWriter(System.out, true);

    static class pair {
        int r;
        int c;
        int k;

        public pair(int rr, int cc, int kk) {
            r = rr;
            c = cc;
            k = kk;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        int n = in.nextInt();
        String s = in.next();
        char[][] arr = new char[n][n];

        int[][] dirs = { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { -2, 1 }, { -1, 2 }, { 2, 1 }, { 1, 2 } };
        String target = "ICPCASIASG";

        Deque<pair> q = new ArrayDeque<>();

        int k = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(k++);
                if (arr[i][j] == 'I')
                    q.offerLast(new pair(i, j, 0));
            }

        boolean flag = false;
        while (!q.isEmpty()) {
            pair cur = q.pollFirst();

            if (cur.k == target.length() - 1 && arr[cur.r][cur.c] == target.charAt(target.length() - 1)) {
                flag = true;
                break;
            }

            for (int[] dir : dirs) {
                int nr = cur.r + dir[0];
                int nc = cur.c + dir[1];

                if (0 <= nr && nr < n && 0 <= nc && nc < n) {
                    if (cur.k < target.length() && arr[nr][nc] == target.charAt(cur.k + 1))
                        q.offerLast(new pair(nr, nc, cur.k + 1));
                }
            }
        }

        out.println((flag) ? "YES" : "NO");
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
