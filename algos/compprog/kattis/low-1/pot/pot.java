import java.util.*;
import java.io.*;

public class pot {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        int n = in.nextInt();
        int x = 0;
        for (int i = 0; i < n; i++) {
            int pi = in.nextInt();
            int p = pi / 10;
            int pp = pi % 10;
            x += (int) (Math.pow(p, pp));
        }

        out.println(x);
    }
}