import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/341295/Google-or-Online-Assessment-2019-or-Fill-Matrix

public class FillMatrix {
    static PrintWriter out = new PrintWriter(System.out, true);

    static int[][] solve(int n) {
        int max = n * n;
        int[][] nums = new int[n][n];
        int row = n / 2;
        int col = n - 1;

        for (int i = 1; i <= max; i++) {
            nums[row][col] = i;
            row = row - 1;
            col = col + 1;

            if (row < 0 && col < n)
                row = n - 1;
            else if (col == n && row >= 0)
                col = 0;

            if (row >= 0 && col != n && nums[row][col] != 0) {
                row = row + 1 == n ? 0 : row + 1;
                col = col - 2 < 0 ? n - 1 - Math.abs(col - 2) : col - 2;
            }

            if ((row == n || row == -1) && (col == -1 || col == n)) {
                row = 0;
                col = n - 2;
            }
        }
        return nums;
    }

    public static void main(String[] args) throws Exception {
        int[][] ret = solve(2); // null
        if (ret != null) {
            for (int[] row : ret)
                out.println(Arrays.toString(row));
            out.println();
        }

        ret = solve(3); // [8, 3, 4], [1, 5, 9], [6, 7, 2]
        if (ret != null) {
            for (int[] row : ret)
                out.println(Arrays.toString(row));
            out.println();
        }

    }
}