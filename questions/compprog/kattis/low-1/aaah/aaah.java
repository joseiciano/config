import java.util.*;
import java.io.*;

class aaah {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        String a = in.next();
        String b = in.next();

        int[] acount = new int[26];
        int[] bcount = new int[26];

        for (char c : a.toCharArray())
            acount[c - 'a']++;
        for (char c : b.toCharArray())
            bcount[c - 'a']++;

        // out.println(Arrays.toString(acount));
        // out.println(Arrays.toString(bcount));
        if (acount['a' - 'a'] < bcount['a' - 'a'] || acount['h' - 'a'] < bcount['h' - 'a'])
            out.println("no");
        else
            out.println("go");
    }
}