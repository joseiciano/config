import java.util.*;
import java.io.*;

/*
    Google Summer Internship 2021 India OA: Alphabet ordering

    Be greedy, only take when there's no longer a valid subsequence
*/

class alphabetordering {
    static PrintWriter out = new PrintWriter(System.out, true);

    static int solve(String S) {

        char[] s = S.toCharArray();
        int n = s.length;
        int ans = 0;

        for (int i = 1; i < n;) {
            ans++;

            // Since we took careof initial duplicateses, we only have two cases
            // 1. Greater than, 2. Less than
            // If greater than, we need positive monotocity
            if (s[i - 1] <= s[i]) {
                while (i < n && s[i - 1] <= s[i]) {
                    i++;
                }
            }
            // If less than, we need decreasing monotocity
            else {
                while (i < n && s[i - 1] >= s[i]) {
                    i++;
                }
            }

        }

        return ans;
    }

    static int go(String S) {

        char[] s = S.toCharArray();
        int n = s.length;
        int ans = 0;

        for (int i = 0; i < n;) {
            ans++;
            // Skip over duplicate characters
            // And if we are at index 0, skip one over
            char d = s[i];
            while (i < n && s[i] == d)
                i++;
            if (i == n)
                break;

            // Since we took careof initial duplicateses, we only have two cases
            // 1. Greater than, 2. Less than
            // If greater than, we need positive monotocity
            if (s[i] > s[i - 1]) {
                while (i < n && s[i] >= s[i - 1]) {
                    i++;
                }
            }
            // If less than, we need decreasing monotocity
            else {
                while (i < n && s[i] <= s[i - 1]) {
                    i++;
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        out.println(solve("abcdcba"));
        out.println(solve("gfcbdhdd"));
        out.println(solve("ffdhhbbbdeeggbb"));
        out.println(solve("cadhfbbacf"));
        out.println(solve("hheaadbdgdggd"));
        out.println(solve("hcbehahccaag"));
    }
}