import java.util.*;
import java.io.*;

public class herman {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        int r = in.nextInt();

        double euc = Math.PI * r * r;

        // (0, 0)
        // (1, 0)

        double tax = Math.abs(r - 0) * Math.abs(r - 0);
        out.printf("%.6f\n%.6f\n", euc, (double) (tax * 2));
    }
}