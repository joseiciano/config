import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/553399/

public class WaysToSplitString {
    static PrintWriter out = new PrintWriter(System.out, true);

    static int solveOpt(String s) {
        int n = s.length();
        int ways = 0;

        int[][] left = new int[n][26];
        int[][] right = new int[n][26];

        for (int i = 0; i < n; i++) {
            right[0][s.charAt(i) - 'a']++;
            left[n - 1][s.charAt(i) - 'a']++;
        }

        for (int i = 1; i < n; i++) {
            // Shift the pivot index
            left[i][s.charAt(i - 1) - 'a']++;
            right[i][s.charAt(i - 1) - 'a']--;

            // Add everything from the previous index
            for (int j = 0; j < 26; j++) {
                left[i][j] += left[i - 1][j];
                right[i][j] += right[i - 1][j];
            }
        }

        // If the two corresponding indices for left and right are equals, we are good
        // left[i] should match with right[n-i-1]
        for (int i = 0; i < n; i++) {
            // out.println(Arrays.toString(left[i]) + " " + Arrays.toString(right[i]));
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if ((left[i][j] > 0 && right[i][j] == 0) || (left[i][j] == 0 && right[i][j] > 0)) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                ways++;
        }
        return ways;
    }

    static int solve(String s) {
        int n = s.length();
        int ways = 0;

        // For each pivot index, compare left and right substrings
        for (int i = n - 1; i >= 0; i--) {
            Set<Character> left = new HashSet<>();
            Set<Character> right = new HashSet<>();

            for (int j = 0; j < i; j++)
                left.add(s.charAt(j));

            for (int j = i; j < n; j++)
                right.add(s.charAt(j));

            ways += (left.equals(right)) ? 1 : 0;
        }

        return ways;
    }

    public static void main(String[] args) throws Exception {
        out.println(solveOpt("aaaa")); // 3, a-aaa, aa-aa, aaa-a
        out.println(solveOpt("bac")); // 0
        out.println(solveOpt("ababa")); // 2, ab-aba, aba-ba
        out.println(solveOpt("baba")); // 1
    }
}