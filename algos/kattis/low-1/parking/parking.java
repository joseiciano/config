import java.util.*;
import java.io.*;

public class parking {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        int tt = in.nextInt();
        for (int t = 0; t < tt; t++) {
            int n = in.nextInt();

            int[] spots = new int[n];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                spots[i] = in.nextInt();

                min = Math.min(spots[i], min);
                max = Math.max(spots[i], max);
            }

            out.println(2 * (max - min));

        }
    }
}