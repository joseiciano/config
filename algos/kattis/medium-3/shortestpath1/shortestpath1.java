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

class dijkstra {
    int oo = (int) 1e9;
    int n;
    List<edge>[] g;
    int[] dist;
    boolean[] vis;

    class edge implements Comparable<edge> {
        int u;
        int v;
        int w;

        public edge(int uu, int vv, int ww) {
            u = uu;
            v = vv;
            w = ww;
        }

        public int compareTo(edge e) {
            return w - e.w;
        }

        public String toString() {
            return "(" + v + ": " + w + ")";
        }
    }

    public dijkstra(int n) {
        this.n = n;
        g = new List[n];

        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<edge>();

        dist = new int[n];
        vis = new boolean[n];
    }

    void addedge(int u, int v, int w) {
        g[u].add(new edge(u, v, w));
    }

    void dijkstras(int s) {
        dist = new int[n];
        vis = new boolean[n];
        PriorityQueue<edge> minheap = new PriorityQueue<>();

        Arrays.fill(dist, oo);
        dist[s] = 0;

        for (int i = 0; i < n; i++) {
            minheap.add(new edge(-1, i, dist[i]));
        }

        while (!minheap.isEmpty()) {
            // Smallest distance vertex
            edge v = minheap.poll();
            if (vis[v.v])
                continue;

            vis[v.v] = true;

            for (edge next : g[v.v]) {
                if (dist[v.v] + next.w < dist[next.v]) {
                    dist[next.v] = dist[v.v] + next.w;
                    minheap.add(new edge(-1, next.v, dist[next.v]));
                }
            }
        }
    }
}

class shortestpath1 {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        int s = in.nextInt();

        while (n != 0 || m != 0 || q != 0 || s != 0) {
            dijkstra dj = new dijkstra(n);

            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                int w = in.nextInt();

                dj.addedge(u, v, w);
            }

            dj.dijkstras(s);

            for (int i = 0; i < q; i++) {
                int v = in.nextInt();
                if (v > n || dj.dist[v] == dj.oo) {
                    out.println("Impossible");
                } else {
                    out.println(dj.dist[v]);
                }
            }

            n = in.nextInt();
            m = in.nextInt();
            q = in.nextInt();
            s = in.nextInt();
        }

    }
}