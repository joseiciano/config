/*This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
*/

import java.util.*;
import java.io.*;

class productexceptself {
    static PrintWriter out = new PrintWriter(System.out, true);

    static int[] solve(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ret = new int[n];
        
        for (int i = 0; i < n; i++) {
            left[i] = right[i] = ret[i] = 1;
        }

        for (int i = 1; i < n; i++) 
            left[i] = left[i-1] * arr[i-1];
        for (int i = n-2; i >= 0; i--)
            right[i] = right[i+1] * arr[i+1];

        for (int i = 0; i < n; i++)
            ret[i] = left[i] * right[i];
        
        return ret;
    }
    public static void main(String[] args) throws Exception {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {3, 2, 1};

        out.println(Arrays.toString(solve(a)));
        out.println(Arrays.toString(solve(b)));
    }
}