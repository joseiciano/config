import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/397156/
public class RelativeSort {
    static PrintWriter out = new PrintWriter(System.out, true);

    static int solve(int[] A, int[] B) {
        int n = A.length;
        int[] swap = new int[n];
        int[] noswap = new int[n];

        Arrays.fill(swap, Integer.MAX_VALUE);
        Arrays.fill(noswap, Integer.MAX_VALUE);
        swap[0] = 1;
        noswap[0] = 0;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                swap[i] = 1 + swap[i - 1];
                noswap[i] = swap[i - 1];
            }

            if (A[i] > B[i - 1] && B[i] > B[i - 1]) {
                swap[i] = Math.min(swap[i], 1 + noswap[i - 1]);
                noswap[i] = Math.min(noswap[i], swap[i - 1]);
            }
        }

        return Math.min(swap[n - 1], noswap[n - 1]);
    }

    public static void main(String[] args) throws Exception {
        int[] a = new int[] { 1, 4, 4, 9 };
        int[] b = new int[] { 2, 3, 5, 10 };

        out.println(solve(a, b)); // 1
    }
}