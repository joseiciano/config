import java.util.*;
import java.io.*;

class trik {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        int[] cups = new int[3];
        cups[0] = 1;

        String moves = in.next();
        for (char c : moves.toCharArray()) {
            if (c == 'A') {
                swap(cups, 0, 1);
            } else if (c == 'B') {
                swap(cups, 1, 2);
            } else if (c == 'C') {
                swap(cups, 0, 2);
            }
        }

        for (int i = 0; i < 3; i++) {
            if (cups[i] > 0)
                out.println((i + 1));
        }

    }

    static void swap(int[] c, int a, int b) {
        int t = c[b];
        c[b] = c[a];
        c[a] = t;
    }
}