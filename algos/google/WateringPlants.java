import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/394347/

public class WateringPlants {
    static PrintWriter out = new PrintWriter(System.out, true);

    static int solve(int[] plants, int cap1, int cap2) {
        int ret = 0;
        int n = plants.length;

        int can1 = 0;
        int can2 = 0;

        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if (can1 < plants[i]) {
                ret++;
                can1 = cap1;
            }
            can1 -= plants[i];

            if (can2 < plants[j]) {
                ret++;
                can2 = cap2;
            }
            can2 -= plants[j];
        }

        if (plants[n / 2] > (can1 + can2))
            ret++;

        return ret;
    }

    public static void main(String[] args) throws Exception {
        int[] plants = new int[] { 2, 4, 5, 1, 2 };
        int cap1 = 5;
        int cap2 = 7;
        out.println(solve(plants, cap1, cap2)); // 3
    }
}