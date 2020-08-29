import java.util.*;
import java.io.*;

public class frog {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int oo = (int) 1000;
        int soo = (int) 1e9;
        int n = in.nextInt();
        int d = in.nextInt();

        int[] dp = new int[n];
        int i = 0;
        String tile = in.next();

        for (char cc : tile.toCharArray())
            dp[i++] = cc == '.' ? oo : soo;

        dp[n - 1] = 0;
        for (i = n - 1; i >= 0; i--) {
            if (dp[i] != soo)
                for (int j = i - 1, k = 0; k <= d; j--, k++) {
                    if (j < 0)
                        break;

                    if (dp[j] != soo)
                        dp[j] = Math.min(dp[i] + 1, dp[j]);
                }
        }

        out.println((dp[0] < oo) ? dp[0] : 0);
        // out.println(min);
    }
}