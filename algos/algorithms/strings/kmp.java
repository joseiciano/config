import java.util.*;
import java.io.*;

/*
    Useful for checking if a substring exists in a string

    Used by checking pattern string has a substring suffix that is a prefix
    If there is a mismatch, go directly after the prefix

    Build Table:
        Time: O(m)
        Space: O(m)

    Matching:
        Time: O(n)
        Space: O(1)

    Total: 
        Time: O(m + n)
        Space: O(m)
*/

class kmp {

    // prefix-suffix table for kmp
    static int[] buildtable(String a) {
        int n = a.length();

        int[] table = new int[n];

        for (int i = 0, j = i + 1; j < n;) {
            if (a.charAt(j) == a.charAt(i)) // Prefix suffix match
                table[j++] = 1 + (i++);
            else if (i != 0) // No match, if we are not at starting idx, back it up
                i = table[i - 1];
            else // We at the 0th starting index, so move up
                table[j++] = 0;
        }

        return table;
    }

    static boolean substringsearch(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        int ret = 0; // no of occurances
        int[] table = buildtable(b);

        if (alen == 0 && blen == 0)
            return true;

        for (int i = 0, j = 0; i < alen && j < blen;) {
            if (a.charAt(i) == b.charAt(j)) { // Substring match, so move up
                i++;
                j++;
            } else {
                if (j != 0) // If j is not at starting idx, jump back
                    j = table[j - 1];
                else // If j is at starting idx, increment main string pointer
                    i++;
            }

            if (j == blen) { // Found a match, so increment out counter
                ret++;
                j = table[j - 1]; // May have overlap, so go back
            }
        }

        return ret > 0;
    }

    public static void main(String[] args) {
        String a = "";
        String b = "";

        // a = "adsgwadsxdsgwadsgz";
        // b = "dsgwadsgz"; // true

        // a = "abcxabcdabcdabcy";
        // b = "abcdabcy"; // true

        // a = "abcxabcdabcdabcy";
        // b = "xyz"; // false
        System.out.println(substringsearch(a, b));
    }
}