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

class floydwarshall {
    int oo = (int) 1e9;
    int n; // vertices
    int[][] graph; // adjacency matrix
    int[][] dist; // shortest path from u to v, leaves graph as is
    int[][] parent; // Parent node for shortest dist

    public floydwarshall(int n) {
        this.n = n;
        graph = new int[n][n];
        dist = new int[n][n]; // If you want speed remove this
        parent = new int[n][n]; // If you want speed remove this

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                    dist[i][j] = 0;
                    parent[i][j] = i;
                } else {
                    graph[i][j] = oo;
                    dist[i][j] = oo;
                    parent[i][j] = -1;
                }
            }
    }

    void addedge(int u, int v, int w) {
        graph[u][v] = w;
        dist[u][v] = w;
    }

    void printgraph() {
        for (int[] row : graph)
            System.out.println(Arrays.toString(row));
    }

    void printdist() {
        for (int[] row : dist)
            System.out.println(Arrays.toString(row));
    }

    void warshall() {
        // Add all vertices one by one to set of intermediate vertices
        // Before Iteration:
        // We have shortest dist of vertices with {0...k-1} as intermediary
        // After Iteeration:
        // We have shortest dist of vertices with {0,...,k-1, k} as intermediary
        for (int k = 0; k < n; k++) // Check all subsets
            for (int i = 0; i < n; i++) // Set i as source
                for (int j = 0; j < n; j++) // Pick all vertices as destination for i
                    if (dist[i][j] > dist[i][k] + dist[k][j] && dist[i][k] < oo && dist[k][j] < oo)
                        dist[i][j] = dist[i][k] + dist[k][j];

        // Negative cycles
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; dist[i][j] != -oo && k < n; k++)
                    if (dist[k][k] < 0 && dist[i][k] != oo && dist[k][j] != oo)
                        dist[i][j] = -oo;

    }
}

class allpairspath {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        int oo = (int) (1e9);

        while (n != 0) {
            int[][] dist = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    dist[i][j] = (i == j) ? 0 : oo;

            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                int w = in.nextInt();

                dist[u][v] = (w < dist[u][v]) ? w : dist[u][v];
            }

            for (int k = 0; k < n; k++)
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        if (dist[i][j] > dist[i][k] + dist[k][j] && dist[i][k] < oo && dist[k][j] < oo)
                            dist[i][j] = dist[i][k] + dist[k][j];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    for (int k = 0; dist[i][j] != -oo && k < n; k++)
                        if (dist[k][k] < 0 && dist[i][k] != oo && dist[k][j] != oo)
                            dist[i][j] = -oo;

            for (int i = 0; i < q; i++) {
                int u = in.nextInt();
                int v = in.nextInt();

                if (dist[u][v] == oo)
                    out.println("Impossible");
                else if (dist[u][v] == -oo)
                    out.println("-Infinity");
                else if (u == v)
                    out.println(0);
                else
                    out.println(dist[u][v]);
            }
            out.println();
            n = in.nextInt();
            m = in.nextInt();
            q = in.nextInt();
        }
    }
}