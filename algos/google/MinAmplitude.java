import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/553399/
public class MinAmplitude {

    static PrintWriter out = new PrintWriter(System.out, true);

    static int solveOpt(int[] arr) {
        int amp = Integer.MAX_VALUE;
        if (arr.length < 4)
            return 0;

        PriorityQueue<Integer> topPQ = new PriorityQueue<>();
        PriorityQueue<Integer> bottomPQ = new PriorityQueue<>(Collections.reverseOrder());

        // O(1) time since we at most have 5 elements in both priorityqueues
        for (int i : arr) {
            topPQ.add(i);
            if (topPQ.size() > 4)
                topPQ.poll();

            bottomPQ.add(i);
            if (bottomPQ.size() > 4)
                bottomPQ.poll();
        }

        int[] top4 = new int[4];
        int[] bottom4 = new int[4];

        for (int i = 0; i < 4; i++) {
            top4[i] = topPQ.poll();
            bottom4[3 - i] = bottomPQ.poll();
        }

        // For each case, find the min
        for (int i = 0; i < 4; i++)
            amp = Math.min(amp, top4[i] - bottom4[i]);

        return amp;
    }

    static int solve(int[] arr) {
        int n = arr.length - 1;

        Arrays.sort(arr);

        int case1 = arr[n - 3] - arr[0];
        int case2 = arr[n - 2] - arr[1];
        int case3 = arr[n - 1] - arr[2];
        int case4 = arr[n] - arr[3];

        return Math.min(case1, Math.min(case2, Math.min(case3, case4)));
    }

    public static void main(String[] args) throws Exception {
        int[] in = new int[] { -1, 3, -1, 8, 5, 4 };
        out.println(solveOpt(in));

        in = new int[] { 10, 10, 3, 4, 10 };
        out.println(solveOpt(in));
    }
}