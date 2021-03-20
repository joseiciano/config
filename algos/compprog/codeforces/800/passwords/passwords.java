import java.util.*;
import java.io.*;

public class passwords {
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

  static final PrintWriter out = new PrintWriter(System.out, true);
  // static final FastScanner in = new FastScanner(passwords.txt);
  static final int oo = (int) 1e9;
  static final int MOD = (int) 1e9 + 7;
  static final FastScanner in = new FastScanner();

  static char[] s;
  static int n;
  static int[][] dp;

  public static void main(String[] args) throws Exception {
    int te = in.nextInt();

    for (int t = 1; t <= te; t++) {
      solve();
    }
  }

  static void solve() throws Exception {
    n = in.nextInt();
    s = in.next().toCharArray();

    dp = new int[10][n+1];
    for (int i = 0; i < 10; i++) Arrays.fill(dp[i], -1);

    int ret = dfs(0, 1);
    out.println(ret);
  }

  static int dfs(int idx, int prev) {
      if (idx == n) 
          return 1;
    if (dp[idx][prev] > -1) return dp[idx][prev];  
      
      int ways = 0;

      for (int toPlace = 1; toPlace < 10; toPlace++) {
          if (toPlace < prev) continue;
          if (s[idx] != '-' && (s[idx]-'0') != toPlace) continue;
          ways += dfs(idx+1, toPlace);
          ways %= MOD;
      }

      return dp[idx][prev] = ways;
  }
}