import java.util.*;
import java.io.*;

public class speedlimit {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == -1)
                break;
            int[][] time = new int[n + 1][n + 1];
            int total = 0;
            for (int i = 1; i <= n; i++) {
                time[i][0] = in.nextInt();
                time[i][1] = in.nextInt();

                int speed = time[i][0] * (time[i][1] - time[i - 1][1]);
                total += speed;

            }

            out.println(total + " miles");
        }
    }
}