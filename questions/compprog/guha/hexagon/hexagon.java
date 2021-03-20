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

public class hexagon {
  static PrintWriter out = new PrintWriter(System.out, true);
  static FastScanner in = new FastScanner();

  public static void main(String[] args) throws Exception {
    int te = in.nextInt();

    while (te-- > 0) {
      int[][] hex = new int[7][];

      for (int i = 0; i < 7; i++) {
        int[] row = new int[6];

        for (int j = 0; j < 6; j++) {
          row[j] = in.nextInt();
        }

        hex[i] = row;
      }

      solve(hex);
    }

  }

  static void solve(int[][] hex) throws Exception {

  }

  static boolean go() {

  }
}