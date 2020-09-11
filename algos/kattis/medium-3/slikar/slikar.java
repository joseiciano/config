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

public class slikar {
    static PrintWriter out = new PrintWriter(System.out, true);
    static int[][] dirs = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
    static int r;
    static int c;
    static char[][] map;
    static boolean[][] vis;

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        r = in.nextInt();
        c = in.nextInt();

        map = new char[r][c];
        vis = new boolean[r][c];

        Deque<int[]> pq = new ArrayDeque<>();
        Deque<int[]> fq = new ArrayDeque<>();
        int[] end = null;

        for (int i = 0; i < r; i++) {
            String s = in.nextLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'S')
                    pq.offer(new int[] { i, j, 0 });
                else if (map[i][j] == '*')
                    fq.offer(new int[] { i, j });
                else if (map[i][j] == 'D')
                    end = new int[] { i, j };
            }
        }

        if (end == null)
            end = new int[] { -1, -1 };

        int count = -1;

        while (!pq.isEmpty() && count == -1) {
            for (int level = fq.size(); level > 0; level--) {
                int[] cur = fq.pollFirst();

                for (int[] dir : dirs) {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];

                    if (isin(nr, nc, true) && !vis[nr][nc]) {
                        map[nr][nc] = '*';
                        fq.offer(new int[] { nr, nc });
                    }
                }
            }

            for (int level = pq.size(); level > 0; level--) {
                int[] cur = pq.pollFirst();

                vis[cur[0]][cur[1]] = true;

                if (cur[0] == end[0] && cur[1] == end[1]) {
                    count = cur[2];
                    break;
                }

                for (int[] dir : dirs) {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];

                    if (isin(nr, nc, false) && !vis[nr][nc]) {
                        vis[nr][nc] = true;
                        pq.offer(new int[] { nr, nc, cur[2] + 1 });
                    }
                }
            }
        }

        out.println(count > -1 ? count : "KAKTUS");
    }

    static boolean isin(int rr, int cc, boolean flag) {
        return 0 <= rr && rr < r && 0 <= cc && cc < c && map[rr][cc] != '*' && map[rr][cc] != 'X'
                && (!flag || flag && map[rr][cc] != 'D');
    }

    static void print() {
        for (char[] row : map)
            out.println(Arrays.toString(row));
    }
}
