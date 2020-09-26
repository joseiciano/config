import java.util.*;
import java.io.*;

public class reversebinary {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        int n = in.nextInt();

        String binary = Integer.toBinaryString(n);

        StringBuilder str = new StringBuilder();

        for (int i = binary.length() - 1; i >= 0; i--)
            str.append(binary.charAt(i));

        out.println(Integer.parseInt(str.toString(), 2));
    }
}