import java.util.*;
import java.io.*;

public class pet {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        int[] s = new int[5];

        int maxi = -1;
        int maxr = -1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                s[i] += in.nextInt();
            }
            if (s[i] > maxr) {
                maxr = s[i];
                maxi = i;
            }
        }

        out.println((maxi + 1) + " " + maxr);
    }
}