import java.util.*;
import java.io.*;

/*
    Take as we go, if we can
    The DP rows are the current item we looking at
    The DP cols are the current weight we can use
*/

public class knapsack {
    static class pair implements Comparable<pair> {
        int v; // value
        int w; // weight

        public pair(int ww, int vv) {
            v = vv;
            w = ww;
        }

        public int compareTo(pair p) {
            return (w != p.w) ? w - p.w : v - p.v;
        }
    }

    static PrintWriter out = new PrintWriter(System.out, true);

    static int go(pair[] items, int c) {

        Arrays.sort(items);
        int n = items.length;
        int[][] dp = new int[n + 1][c + 1];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= c; j++) {
                if (items[i - 1].w <= j) {
                    int take = dp[i - 1][j - items[i - 1].w] + items[i - 1].v;
                    int donttake = dp[i - 1][j];
                    dp[i][j] = Math.max(take, donttake);
                } else
                    dp[i][j] = dp[i - 1][j];
            }

        return dp[n][c];
    }

    public static void main(String[] args) {
        pair[] items = { new pair(5, 60), new pair(3, 50), new pair(4, 70), new pair(2, 30) };
        out.println(go(items, 5));
    }
}