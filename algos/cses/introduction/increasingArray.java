import java.util.*;
import java.io.*;

public class increasingArray {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        long prev = in.nextLong();
        long ret = 0;

        for (int i = 0; i < n - 1; i++) {
            long cur = in.nextLong();

            if (cur < prev)
                ret += (prev - cur);
            else
                prev = cur;
        }

        out.println(ret);
    }
}
