import java.util.*;

public class findConnectedComponents {
    static int n; // Number of nodes
    static Map<Integer, ArrayList<Integer>> g; // Graph representation adjacency list
    static int count; // the id we will give to each component
    static int[] components; // ids of component elements
    static boolean[] vis; // visited array

    static void dfs(int node) {
        if (!vis[node])
            return;

        vis[node] = true;
        components[node] = count; // Mark it with this id
        ArrayList<Integer> neighbors = g.get(node);

        for (Integer neighbor : neighbors)
            if (!vis[neighbor])
                dfs(neighbor);
    }

    public static void main(String[] args) {
        n = 0;
        g = new HashMap<>();

        count = 0;
        components = new int[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(i);
            }
        }

        // Could return (count, components) here as a pair
    }
}