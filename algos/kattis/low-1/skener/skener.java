import java.util.*;
import java.io.*;

class skener {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        // Scanner in = new Scanner(new File("skener.in"));
        PrintWriter out = new PrintWriter(System.out, true);

        int R = in.nextInt();
        int C = in.nextInt();
        int Zr = in.nextInt();
        int Zc = in.nextInt();

        char[][] matrix = new char[R * Zr][C * Zc];

        for (int i = 0; i < R; i++) {
            String symbols = in.next();
            for (int j = 0; j < symbols.length(); j++) {
                matrix[i][j] = symbols.charAt(j);
            }
        }

        for (int i = 0; i < R * Zr; i++) {
            for (int j = 0; j < C * Zc; j++) {
                out.print(matrix[i / Zr][j / Zc]);
            }
            out.println();
        }
        out.println();
    }
}