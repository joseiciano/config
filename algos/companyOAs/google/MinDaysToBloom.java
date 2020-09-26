import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/334191

public class MinDaysToBloom {
    static PrintWriter out = new PrintWriter(System.out, true);

    static int getcount(int[] roses, int time, int k) {
        int count = 0;

        int i = 0;
        while (i < roses.length) {
            int inbloom = 0;
            while (i < roses.length && roses[i++] <= time && ++inbloom < k)
                ;
            if (inbloom == k)
                count++;
        }

        return count;
    }

    static int solveopt(int[] roses, int k, int n) {
        int max = Arrays.stream(roses).max().getAsInt();

        int lo = 1;
        int hi = max;

        while (lo < hi) {
            int mid = lo + ((hi - lo) / 2);

            int count = getcount(roses, mid, k);

            if (count >= n)
                hi = mid;
            else
                lo = mid + 1;

        }

        return lo;
    }

    static int solve(int[] roses, int k, int n) {
        int max = Arrays.stream(roses).max().getAsInt();

        for (int time = 1; time <= max; time++) {
            if (getcount(roses, time, k) >= n)
                return time;
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
        int[] roses = new int[] { 1, 2, 4, 9, 3, 4, 1 };
        int k = 2;
        int n = 2;

        out.println(solveopt(roses, k, n)); // 4

        roses = new int[] { 1, 5, 6, 2 };
        k = 1;
        n = 4;
        out.println(solveopt(roses, k, n)); // 6

        roses = new int[] { 1, 1, 1, 1 };
        k = 4;
        n = 1;
        out.println(solveopt(roses, k, n)); // 1
    }
}