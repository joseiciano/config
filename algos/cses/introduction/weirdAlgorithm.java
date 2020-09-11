import java.util.*;
import java.io.*;

public class weirdAlgorithm {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong();

        while (n != 1) {
            out.print(n + " ");

            n = (n % 2 == 0) ? n >> 1 : n * 3 + 1;
        }
        out.println(n);
    }
}
