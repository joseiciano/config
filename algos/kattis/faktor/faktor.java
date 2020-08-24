import java.util.*;
import java.io.*;

class faktor {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        int a = in.nextInt();
        int i = in.nextInt();

        out.println(a * (i - 1) + 1);
    }
}