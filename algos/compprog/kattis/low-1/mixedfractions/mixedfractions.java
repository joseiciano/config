import java.util.*;
import java.io.*;

public class mixedfractions {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        long num = in.nextLong();
        long den = in.nextLong();
        while (num != 0 || den != 0) {
            long n = num / den;
            long d = num % den;

            out.println(n + " " + d + " / " + den);

            num = in.nextLong();
            den = in.nextLong();
        }
    }
}