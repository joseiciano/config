import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/853151/Roblox-New-Grad-Online-Assessment-Questions

class CompetitiveGaming {
    static PrintWriter out = new PrintWriter(System.out, true);

    static int go(int n, int k, int[] scores) {
        int[] ranks = new int[n];

        Arrays.sort(scores);

        ranks[n - 1] = 1;
        for (int i = n - 2, idx = 2; i >= 0; i--, idx++) {
            if (scores[i] == scores[i + 1])
                ranks[i] = ranks[i + 1];
            else
                ranks[i] = idx;
        }

        int levelup = 0;
        for (int rank : ranks) {
            if (rank <= k)
                levelup++;
        }

        return levelup;
    }

    public static void main(String[] args) throws Exception {
        int n = 4;
        int k = 3;
        int[] scores = new int[] { 100, 50, 50, 25 };
        out.println(go(n, k, scores)); // 3

        n = 5;
        k = 4;
        scores = new int[] { 20, 40, 60, 80, 100 };
        out.println(go(n, k, scores)); // 4

        n = 5;
        k = 4;
        scores = new int[] { 2, 2, 3, 4, 5 };
        out.println(go(n, k, scores)); // 5
    }
}