import java.util.*;
import java.io.*;

public class oddities {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            out.println(x + " is " + ((x % 2 == 0) ? "even" : "odd"));
        }
    }
}