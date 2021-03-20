import java.util.*;
import java.io.*;

public class directionalmove {
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
  // static final FastScanner in = new FastScanner(directionalmove.txt);
  static final int oo = (int) 1e9;
  static final int MOD = (int) 1e9 + 7;
  static final FastScanner in = new FastScanner();

  public static void main(String[] args) throws Exception {
    int te = in.nextInt();

    for (int t = 1; t <= te; t++) {
      solve();
    }
  }

  static void solve() throws Exception {
    int n = in.nextInt();
    String s = in.next();

    String dirs = "NESW";
    int sx = 1;

    for (char c : s.toCharArray()) {
      sx += (c == '0' ? 1 : -1);

      if (sx < 0)
        sx = 3;
    }

    out.println(dirs.charAt(sx % 4));

  }
}