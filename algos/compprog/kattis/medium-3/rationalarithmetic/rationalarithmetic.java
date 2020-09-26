import java.util.*;
import java.io.*;

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

public class rationalarithmetic {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0) {

            long x1 = in.nextLong();
            long y1 = in.nextLong();

            char op = in.next().toCharArray()[0];

            long x2 = in.nextLong();
            long y2 = in.nextLong();

            long num = 0;
            long den = 0;

            if (op == '+') {
                if (y1 != y2) {
                    num = (x1 * y2) + (x2 * y1);
                    den = y1 * y2;
                } else {
                    num = x1 + x2;
                    den = y1;
                }
            } else if (op == '-') {
                if (y1 != y2) {
                    num = (x1 * y2) - (x2 * y1);
                    den = y1 * y2;
                } else {
                    num = x1 - x2;
                    den = y1;
                }
            } else if (op == '*') {
                num = x1 * x2;
                den = y1 * y2;
            } else {
                num = x1 * y2;
                den = y1 * x2;
            }

            int neg = (num < 0 ? -1 : 1) * (den < 0 ? -1 : 1);
            num *= (num < 0) ? 1 : -1;
            den *= (den < 0) ? 1 : -1;

            long gf = gcd(num, den);
            num /= gf;
            den /= gf;
            out.println((num * neg) + " / " + den);

        }
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
