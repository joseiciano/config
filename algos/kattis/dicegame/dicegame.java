import java.util.*;
import java.io.*;

public class dicegame {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        int gsum = 0;
        for (int i = 0; i < 4; i++)
            gsum += in.nextInt();

        int esum = 0;
        for (int i = 0; i < 4; i++) {
            esum += in.nextInt();
        }

        out.println((gsum == esum) ? "Tie" : (gsum < esum) ? "Emma" : "Gunnar");

    }

    static int f(int a, int b) {
        return ((b) * ((b) + 1)) >> 1;
    }
}