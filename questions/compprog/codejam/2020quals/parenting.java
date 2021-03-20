import java.util.*;
import java.io.*;

class interval implements Comparable<interval> {
  int s;
  int e;
  int i;

  public interval(int ss, int ee, int ii) {
    s = ss;
    e = ee;
    i = ii;
  }

  public int compareTo(interval i) {
    return s - i.s;
  }

  public String toString() {
    return s + " - " + e + ", " + i;
  }
}

public class parenting {
  static PrintWriter out = new PrintWriter(System.out, true);

  static String go(int s, interval[] ints) {
    Arrays.sort(ints);

    char[] sched = new char[s];
    Arrays.fill(sched, 'X');

    int c = ints[0].e;
    sched[ints[0].i] = 'C';
    int j = ints[1].e;
    sched[ints[1].i] = 'J';

    for (int i = 2; i < s; i++) {
      if (c <= ints[i].s) {
        c = ints[i].e;
        sched[ints[i].i] = 'C';
      } else if (j <= ints[i].s) {
        j = ints[i].e;
        sched[ints[i].i] = 'J';
      } else {
        return "IMPOSSIBLE";
      }
    }

    return new String(sched);
  }

  public static void main(String[] args) throws Exception {
    FastScanner in = new FastScanner();

    int T = in.nextInt();

    for (int t = 1; t <= T; t++) {
      int s = in.nextInt();

      interval[] ints = new interval[s];

      for (int i = 0; i < s; i++) {
        ints[i] = new interval(in.nextInt(), in.nextInt(), i);
      }

      out.println("Case #" + t + ": " + go(s, ints));
    }
  }
}

class FastScanner {
  final private int BUFFER_SIZE = 1 << 16;
  private DataInputStream din;
  private byte[] buffer;
  private int bufferPointer, bytesRead;

  public FastScanner() {
    din = new DataInputStream(System.in);
    buffer = new byte[BUFFER_SIZE];
    bufferPointer = bytesRead = 0;
  }

  public FastScanner(String filename) throws Exception {
    din = new DataInputStream(new FileInputStream(filename));
    buffer = new byte[BUFFER_SIZE];
    bufferPointer = bytesRead = 0;
  }

  public String readLine() throws Exception {
    byte[] buf = new byte[64];
    int cin = 0, c;
    while ((c = read()) != -1) {
      if (c == '\n')
        break;
      buf[cin++] = (byte) c;
    }
    return new String(buf, 0, cin);
  }

  public int nextInt() throws Exception {
    int ret = 0;
    byte c = read();
    while (c <= ' ')
      c = read();
    boolean neg = (c == '-');
    if (neg)
      c = read();
    do {
      ret = ret * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');
    return ret * (neg ? -1 : 1);
  }

  public long nextLong() throws Exception {
    long ret = 0;
    byte c = read();
    while (c <= ' ')
      c = read();
    boolean neg = (c == '-');
    if (neg)
      c = read();
    do {
      ret = ret * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');
    return ret * (neg ? -1 : 1);
  }

  public double nextDouble() throws Exception {
    double ret = 0, div = 1;
    byte c = read();
    while (c <= ' ')
      c = read();
    boolean neg = (c == '-');
    if (neg)
      c = read();
    do {
      ret = ret * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');
    if (c == '.') {
      while ((c = read()) >= '0' && c <= '9') {
        ret += (c - '0') / (div *= 10);
      }
    }
    return ret * (neg ? -1 : 1);
  }

  private void fillBuffer() throws Exception {
    bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
    if (bytesRead == -1)
      buffer[0] = -1;
  }

  private byte read() throws Exception {
    if (bufferPointer == bytesRead)
      fillBuffer();
    return buffer[bufferPointer++];
  }

  public void close() throws Exception {
    if (din != null)
      din.close();
  }
}
