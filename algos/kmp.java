import java.util.*;
import java.io.*;

class kmp {

    // prefix-suffix table for kmp
    static int[] buildtable(String a) {
        int n = a.length();
        int[] table = new int[n];

        int index = 0;
        int i = index + 1;

        // Traverse through whole string
        while (i < n) {
            // We found a prefix-suffix match
            if (a.charAt(i) == a.charAt(index))
                table[i++] = 1 + (index++);
            // If we are not at the 0th starting index, back it up
            else if (index != 0)
                index = table[index - 1];
            // We are at the 0th starting index, move up
            else
                table[i++] = 0;
        }

        System.out.println(Arrays.toString(table));
        return table;
    }

    static boolean substringsearch(String a, String b) {
        int alen = a.length();
        int blen = b.length();

        int[] table = buildtable(b);
        int i = 0;
        int j = 0;
        while (i < alen && j < blen) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0)
                    j = table[j - 1];
                else
                    i++;
            }
        }

        return j == blen;
    }

    public static void main(String[] args) {
        String a = "adsgwadsxdsgwadsgz";
        String b = "dsgwadsgz";

        // String a = "abcxabcdabcdabcy";
        // String b = "abcdabcy";
        System.out.println(substringsearch(a, b));
    }
}