import java.util.*;
import java.io.*;

public class cold {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        int n = in.nextInt();
        int r = 0;
        for (int i = 0; i < n; i++) {
            r += (in.nextInt() < 0) ? 1 : 0;
        }
        out.println(r);
    }
}