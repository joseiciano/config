import java.util.*;
import java.io.*;

public class nesting {
  static PrintWriter out = new PrintWriter(System.out, true);

  static int toi(char c) {
    return c - '0';
  }

  public static void main(String[] args) throws Exception {

    FastScanner in = new FastScanner();
    int T = in.nextInt();

    for (int t = 1; t <= T; t++) {

      String sb = "0" + in.nextLine() + "0";
      char[] s = sb.toCharArray();

      Deque<Character> dq = new ArrayDeque<>();

      for (int i = 1; i < s.length; i++) {
        int diff = toi(s[i]) - toi(s[i - 1]);

        while (diff < 0) {
          dq.offerLast(')');
          diff += 1;
        }
        while (diff > 0) {
          dq.offerLast('(');
          diff -= 1;
        }

        if (i + 1 != s.length) {
          dq.offerLast(s[i]);
        }
      }

      StringBuilder sp = new StringBuilder();
      while (!dq.isEmpty()) {
        sp.append(dq.pollFirst());
      }

      out.println("Case #" + t + ": " + sp);
    }
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
