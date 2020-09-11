import java.util.*;
import java.io.*;

public class repetitions {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        char[] dna = in.next().toCharArray();

        int count = 0;
        int max = 0;
        char c = dna[0];

        for (int i = 0; i < dna.length; i++) {
            if (dna[i] == c) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
                c = dna[i];
                i--;
            }
        }

        max = Math.max(max, count);
        out.println(max);
    }
}
