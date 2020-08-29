import java.util.*;
import java.io.*;

public class vowel {

    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        String s = in.next();
        int count = 0;

        for (char cc : s.toCharArray()) {
            count += (cc == 'a' || cc == 'e' || cc == 'i' || cc == 'o' || cc == 'u') ? 1 : -1;
        }

        out.println(count > 0 ? 1 : 0);
    }
}