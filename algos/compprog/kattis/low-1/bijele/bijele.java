import java.util.*;
import java.io.*;

public class bijele {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        int[] pieces = new int[6];
        int[] match = { 1, 1, 2, 2, 2, 8 };
        int[] ret = new int[6];

        for (int i = 0; i < 6; i++) {
            pieces[i] = in.nextInt();
            if (i == 0)
                out.print(match[i] - pieces[i]);
            else
                out.print(" " + (match[i] - pieces[i]));
        }

        out.println();
    }
}