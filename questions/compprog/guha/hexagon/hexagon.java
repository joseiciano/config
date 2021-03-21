/*
    Author: Jose Iciano
    Problem: hexagon
*/

import java.util.*;
import java.io.*;

public class hexagon {
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
  static FastScanner in;
  static final int oo = (int) 1e9;
  static final int MOD = (int) 1e9 + 7;

  public static void main(String[] args) throws Exception {
    in = new FastScanner();
    // in = new FastScanner("hexagon");

    int te = in.nextInt();

    for (int t = 1; t <= te; t++) {
      solve();
    }
  }

  static int[] finalOrder = null;

  static void solve() throws Exception {
    int[][] hexagons = new int[7][6];
    finalOrder = null;

    /*
     * 0 = top, 1 = topright, 2 = botright, 3 = bot, 4 = botleft, 5 = topleft
     */
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 6; j++) {
        hexagons[i][j] = in.nextInt();
      }
    }

    // 0 = center, 1 = top, 2 = topright, 3 = botright, 4 = bot, 5 = botleft, 6 =
    // topleft
    int[] order = new int[7];
    boolean[] used = new int[7];
    int idx = 0;
    dfs(hexagons, order, used, idx);

    if (finalOrder != null) {
      out.println(Arrays.toString(finalOrder));
    }
  }

  static void dfs(int[][] hexagons, int[] order, boolean[] used, int idx) {
    if (idx == 7) {
      int[][] hexcopy = copy(hexagons);

      if (canWork(hexcopy, order)) {

      }
    }

    for (int i = 0; i < 7; i++) {
      if (!used[idx]) {
        used[idx] = true;
        order[idx] = i;
        dfs(hexagons, order, used, idx + 1);
        used[idx] = false;
      }
    }
  }

  static boolean canWork(int[][] hexagons, int[] order) {
    // Rotate center so 0 is at top
    rotate(hexagons[order[0]], 0, 0);

    for (int i = 1; i < 7; i++) {
      rotate(hexagons[order[i]], hexagons)
    }
  }

  static void rotate(int[] row, int targetNumber, int targetPosition) {
    while (row[targetPosition] != targetNumber) {
      int temp = row[0];

      for (int i = 0; i < 5; i++)
        row[i] = row[i + 1];
      row[5] = temp;
    }
  }

  static int[][] copy(int[][] hexagons) {
    int[][] cpy = new int[7][6];
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 6; j++) {
        cpy[i][j] = hexagons[i][j];
      }
    }

    return cpy;
  }
}