import java.util.*;
import java.io.*;

public class zamka {

    static long sum(long num) {
        long dig = 0;
        while (num > 0) {
            dig += num % 10;
            num /= 10;
        }
        return dig;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        long l = in.nextLong();
        long d = in.nextLong();
        long x = in.nextLong();

        long lo = -1;
        long hi = -1;
        for (long i = l; i <= d; i++) {
            if (sum(i) == x) {
                lo = i;
                break;
            }
        }
        for (long i = d; i >= l; i--) {
            if (sum(i) == x) {
                hi = i;
                break;
            }
        }

        out.println(lo);
        out.println(hi);
    }
}