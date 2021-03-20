import java.util.*;
import java.io.*;

public class rijeci {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        int k = in.nextInt();

        int a = 1;
        int b = 0;

        for (int i = 1; i <= k; i++) {
            int ta = b;
            int tb = a + b;
            a = ta;
            b = tb;
        }
        out.println(a + " " + b);
    }

}