import java.util.*;
import java.io.*;

public class puzzle {
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

    static PrintWriter out;
    static FastScanner in;
    // static final FastScanner in = new FastScanner();

    static final int oo = (int) 1e9;
    static final int MOD = (int) 1e9 + 7;
    static HashMap<String, Integer> states;

    public static void main(String[] args) throws Exception {
        out = new PrintWriter(System.out, true);
        in = new FastScanner("puzzle.in");

        serialize();
        int te = in.nextInt();

        for (int t = 1; t <= te; t++) {
            solve();
        }
    }

    static void solve() throws Exception {
        int[][] board = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = in.nextInt();
            }
        }
        String state = tos(board);
        out.println(states.get(state));
    }

    static void serialize() {
        states = new HashMap<>();
        int[][] board = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };

        String state = tos(board);
        Deque<String> q = new ArrayDeque<>();
        q.offerLast(state);

        int ways = -1;
        while (!q.isEmpty()) {

            int size = q.size();
            ways += 1;

            for (int le = 0; le < size; le++) {
                String curs = q.pollFirst();
                int[][] cur = tob(curs);

                states.put(curs, ways);

                String[] next = nextMoves(cur);

                for (String move : next) {
                    if (move == null)
                        continue;
                    if (!states.containsKey(move)) {
                        states.put(move, ways + 1);
                        q.offerLast(move);
                    }
                }

            }
        }

        out.println(states.size());
    }

    static String[] nextMoves(int[][] board) {
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        int[] ij = getZero(board);
        String[] ret = new String[4];
        int i = 0;
        for (int[] dir : dirs) {
            int[] nij = { ij[0] + dir[0], ij[1] + dir[1] };

            if (0 <= nij[0] && nij[0] < 3 && 0 <= nij[1] && nij[1] < 3) {
                swap(board, ij, nij);
                ret[i++] = tos(board);
                swap(board, ij, nij);
            }
        }

        return ret;
    }

    static void print(int[][] board) {
        out.println();
        for (int[] row : board)
            out.println(Arrays.toString(row));
    }

    static void swap(int[][] board, int[] ij, int[] nij) {
        int temp = board[ij[0]][ij[1]];
        board[ij[0]][ij[1]] = board[nij[0]][nij[1]];
        board[nij[0]][nij[1]] = temp;
    }

    static int[] getZero(int[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == 0)
                    return new int[] { i, j };
        return new int[] { -1, -1 };
    }

    static String tos(int[][] board) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                str.append(board[i][j]);
            }
        }

        return str.toString();
    }

    static int[][] tob(String s) {
        int[][] board = new int[3][3];

        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = s.charAt(k++) - '0';
            }
        }

        return board;
    }
}