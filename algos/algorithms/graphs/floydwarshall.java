class floydwarshall {
    public int oo = (int) 1e9;
    public int n; // vertices
    public int[][] graph; // adjacency matrix
    public int[][] dist; // shortest path from u to v, leaves graph as is
    public int[][] parent; // Parent node for shortest dist

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

    public void addedge(int u, int v, int w) {
        graph[u][v] = w;
        dist[u][v] = w;
    }

    public void printgraph() {
        for (int[] row : graph)
            System.out.println(Arrays.toString(row));
    }

    public void printdist() {
        for (int[] row : dist)
            System.out.println(Arrays.toString(row));
    }

    public void warshall() {
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