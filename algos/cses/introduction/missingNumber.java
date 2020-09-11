import java.util.*;
import java.io.*;

public class missingNumber {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong();

        long sum = 0;
        for (int i = 0; i < n - 1; i++)
            sum += in.nextInt();

        long expected = (n * (n + 1)) >> 1;

        out.println(expected - sum);
    }
}
