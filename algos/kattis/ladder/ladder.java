import java.util.*;
import java.io.*;

public class ladder {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);
        int h = in.nextInt();
        int v = in.nextInt();
        int arc = (int) Math.ceil(h / Math.sin(Math.toRadians(v)));

        out.println(arc);
    }
}