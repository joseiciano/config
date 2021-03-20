import java.util.*;
import java.io.*;

public class gridpaths {
    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        int n = in.nextInt();

        boolean[][] grid = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = in.next();
            for (int j = 0; j < n; j++)
                if (line.charAt(j) == '*')
                    grid[i][j] = true;
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (grid[0][i]) {
                dp[0][i] = 0;
                break;
            } else
                dp[0][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (grid[i][0]) {
                dp[i][0] = 0;
                break;
            } else
                dp[i][0] = 1;
        }

        int mod = (int) 1e9 + 7;

        for (int i = 1; i < n; i++)
            for (int j = 1; j < n; j++)
                if (!grid[i][j])
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;

        System.out.println(dp[n - 1][n - 1]);
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
