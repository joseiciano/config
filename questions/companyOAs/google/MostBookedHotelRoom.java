import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/421787/
/*
    Idea: We can just simulate this, count each check in and find the max
            To deal with ties, just go in order from 0-9, A-Z. 
            We will see the lexiconographic first answer first

    O(n) time as we iterate through arr for a total of n times
    The double for loop is O(1) since we do 260 at most

    O(1) space as we only use a constant 260 space
*/

public class MostBookedHotelRoom {
    static PrintWriter out = new PrintWriter(System.out, true);

    static String solve(String[] arr) {
        int n = arr.length;

        int[][] count = new int[10][26];

        for (String str : arr) {
            if (str.charAt(0) == '+') {
                count[str.charAt(1) - '0'][str.charAt(2) - 'A']++;
            }
        }

        String res = "";
        int max = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 26; j++) {
                if (count[i][j] > max) {
                    res = Character.toString((char) (i + '0')) + Character.toString((char) (j + 'A'));
                    max = count[i][j];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        out.println(solve(new String[] { "+1A", "+3E", "-1A", "+4F", "+1A", "-3E" })); // 1A
        out.println(solve(new String[] { "+1E", "-1E", "+1E", "-1E", "+1E", "-1E", "+1E", "-1E", "+2A", "-2A", "+2A",
                "-2A", "+2A", "-2A", "+2A", "-2A", "+2B", "-2B", "+2B", "-2B", "+2B", "-2B", "+2B", "-2B" })); // 1E
                                                                                                               // comes
                                                                                                               // first
        out.println(solve(new String[] { "+1A", "+3E", "-1A", "+4F", "+1A", "-3E", "+1A", "+1A", "+1A", "+1A", "+1A",
                "+1A", "+1A", "+3E" })); // 1A
        out.println(solve(new String[] { "+1A", "+3E", "-1A", "+4F", "+1A", "-3E", "+1A", "+1A", "+1A", "+1A", "+1A",
                "+1A", "+1A", "+3E", "+3E", "+3E", "+3E", "+3E", "+3E" })); // 1A
    }
}