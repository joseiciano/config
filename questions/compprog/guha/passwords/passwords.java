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


public class passwords {
  static PrintWriter out = new PrintWriter(System.out, true);
  static FastScanner in;
  static char[][] sets;
  static boolean[][] used;
  static char[] ret;
  static int rank;
  static int m;
  public static void main(String[] args) throws Exception {
    in = new FastScanner("in.txt");

    int c = in.nextInt();

    sets = new char[20][26];
    used = new boolean[20][26];

    for (int te = 0; te < c; te++) {
      m = in.nextInt();
      for (int i = 0; i < m; i++) {
        String row = in.nextLine();
        sets[i] = row.toCharArray();
        used[i] = new boolean[row.length()];
      }

      ret = new char[m];
      rank = in.nextInt();

      go(0, 0);
    }
  }

  static void go(int row, int k) {
    if (rank <= 0)
      return;

    if (row == m) {
      rank--;

      if (rank == 0)
        System.out.println(new String(ret));
    }
    else {
      for (int i = 0; i < sets[row].length; i++) {
        if (!used[row][i]) {
          used[row][i] = true;
          ret[k] = sets[row][i];
          go(row+1, k+1);
          used[row][i]=false;
        }
      }
    }
  }
}