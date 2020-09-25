import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/853151/Roblox-New-Grad-Online-Assessment-Questions
public class PaintTheCeiling {
    static PrintWriter out = new PrintWriter(System.out, true);

    static long f(int k, int b, int m, long s1min1) {
        return ((k * s1min1 + b) % m) + 1 + s1min1;
    }

    static long go(int n, int s0, int k, int b, int m, long a) {
        long[] s = new long[n];

        s[0] = s0;
        for (int i = 1; i < n; i++)
            s[i] = f(k, b, m, s[i - 1]);

        int i = 0;
        int j = n - 1;
        long count = 0;

        while (i < j) {
            if (s[i] * s[j] <= a) {
                count += (j - i) * 2;
                i++;
            } else
                j--;
        }

        for (long num : s)
            if (num * num <= a)
                count++;

        return count;
    }

    public static void main(String[] args) throws Exception {
        int n = 3;
        int s0 = 1;
        int k = 1;
        int b = 1;
        int m = 2;
        int a = 4;

        out.println(go(n, s0, k, b, m, a)); // 6
    }
}
