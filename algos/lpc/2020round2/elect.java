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


public class elect {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();
        int t = in.nextInt();
        int candidate = 0;
        int electoral = 0;
        boolean wonelec = true;
        boolean woncan = true;
        for (int te = 0; te < t; te++) {
            int e = in.nextInt();
            int c1 = in.nextInt();
            int c2 = in.nextInt();

            if (c1 > c2)
                electoral += e;
            else if (c1 < c2)
                electoral -= e;

            candidate += c1;
            candidate -= c2;
        }

        if (candidate > 0 && electoral > 0)
            out.println(1);
        else if (candidate < 0 && electoral < 0)
            out.println(2);
        else out.println(0);
    }
}
