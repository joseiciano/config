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

class unionfind {
    int size;// ele in union find
    int[] sz; // size of each comp
    int[] id; // points to parent of i, parent[i]. if parent[i] = i, root
    int numComponents;

    public unionfind(int size) {
        this.size = numComponents = size;
        sz = new int[size];
        id = new int[size];

        for (int i = 0; i < size; i++) {
            id[i] = i; // each comp orignally links to itself
            sz[i] = 1; // each comp is originally size 1
        }
    }

    int find(int p) {
        // Find root of component/set
        int root = p;
        while (root != id[root])
            root = id[root];

        // Path compression
        // while (id[p] != root) {
        // int next = id[p];
        // id[p] = root;
        // p = next;
        // }

        return root;
    }

    // checks if p and q are connected
    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // Returns size of component
    int componentSize(int p) {
        return sz[find(p)];
    }

    void unify(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);

        // Elements already in the same component
        if (root1 == root2)
            return;

        if (sz[root1] < sz[root2]) {
            sz[root2] += sz[root1];
            id[root1] = root2;
        } else {
            sz[root1] += sz[root2];
            id[root2] = root1;
        }

        // We got rid of one component
        numComponents--;
    }

    int query() {
        int ret = 0;
        for (int i = 0; i < id.length; i++) {
            if (id[i] != i)
                continue;
            int cz = sz[id[i]];
            ret = ret + (cz * cz);
        }
        System.out.println(Arrays.toString(id));
        System.out.println(Arrays.toString(sz));
        return ret;
    }
}

public class connect {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();
        // FastScanner in = new FastScanner("in.txt");

        int n = in.nextInt();
        int m = in.nextInt();

        unionfind g = new unionfind(n);

        for (int i = 0; i < m; i++) {
            int step = in.nextInt();

            if (step == 1) {
                int u = in.nextInt();
                int v = in.nextInt();

                g.unify(u - 1, v - 1);
            }

            else if (step == 2) {
                int num = g.query();
                int den = g.numComponents;

                int gc = gcd(num, den);
                num /= gc;
                den /= gc;

                out.println(num + "/" + den);
            }
        }
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            a = b;
            b = a % b;
        }
        return a;
    }
}
