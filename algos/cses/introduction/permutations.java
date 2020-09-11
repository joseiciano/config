import java.util.*;
import java.io.*;

public class permutations {

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();
        int n = in.nextInt();

        if (n == 1)
            System.out.println("1");
        else if (n == 2 || n == 3)
            System.out.println("NO SOLUTION");

        StringBuilder str = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 2; i <= n; i += 2)
                str.append(i + " ");
            for (int i = 1; i < n; i += 2)
                str.append(i + " ");
        } else {
            for (int i = n - 1; i > 0; i -= 2)
                str.append(i + " ");
            for (int i = n; i > 0; i -= 2)
                str.append(i + " ");
        }
        System.out.println(str.toString());

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

    public FastScanner(String filename) throws IOException {
        din = new DataInputStream(new FileInputStream(filename));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
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

        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong() throws IOException {
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

    public double nextDouble() throws IOException {
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

        return ret * ((neg) ? -1 : 1);
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din != null)
            din.close();
    }
}
