import java.util.*;
import java.io.*;

/*
    Prompt: 
        A contiguous subarray is defined by an interval of the indices.
        A contiguous subarray is a subarray with consecutive indices.
        Write a function that, given a zero-indexed array, A, of N integers and an integer K,
            returns the largest subarray of length K from all contiguous subarrays of length K
    Example:
        A = [1, 4, 3, 2, 5], K = 4, return [4, 3, 2, 5]
            The two subarrays of size 4 are [1, 4, 3, 2] and [4, 3, 2, 5]
    Params:
        1 <= K <= N <= 100
        1 <= A[J] <= 1000
*/

public class LongestSubarrayLengthK {

    static PrintWriter out = new PrintWriter(System.out, true);

    static int[] LSLKOpt(int[] A, int K) {
        int first = 0;

        for (int i = 1; i < A.length - K + 1; i++)
            if (A[first] < A[i])
                first = i;

        return Arrays.copyOfRange(A, first, first + K);
    }

    static int[] LSLK(int[] A, int K) {
        int[] ret = new int[K];
        Arrays.fill(ret, -1);

        for (int i = 0; i < A.length; i++) {
            int[] temp = new int[K];
            int k = 0;
            if (i + K <= A.length)
                for (int j = i; j < i + K; j++)
                    temp[k++] = A[j];

            if (isGreater(temp, ret) == 1) {
                for (int j = 0; j < K; j++)
                    ret[j] = temp[j];
            }
        }

        return ret;
    }

    // Returns
    // -1: X < Y
    // 0: X == Y
    // 1: X > Y
    static int isGreater(int[] X, int[] Y) {
        for (int i = 0; i < X.length; i++) {
            if (X[i] > Y[i])
                return 1;
            else if (X[i] < Y[i])
                return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        out.println("RESULTS");
        // out.println(Arrays.toString(LSLK(new int[] { 1, 4, 3, 2, 5 }, 4)));
        out.println(Arrays.toString(LSLKOpt(new int[] { 1, 4, 3, 2, 5 }, 4)));
    }
}