import java.util.*;
import java.io.*;

public class bela {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        Map<Character, Integer> dominate = Map.of('A', 11, 'K', 4, 'Q', 3, 'J', 20, 'T', 10, '9', 14, '8', 0, '7', 0);
        Map<Character, Integer> notdominate = Map.of('A', 11, 'K', 4, 'Q', 3, 'J', 2, 'T', 10, '9', 0, '8', 0, '7', 0);

        int n = in.nextInt() * 4;
        char b = in.next().charAt(0);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String s = in.next();
            sum += (s.charAt(1) == b) ? dominate.get(s.charAt(0)) : notdominate.get(s.charAt(0));
        }

        out.println(sum);
    }
}