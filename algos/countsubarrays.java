import java.util.*;
import java.io.*;

public class countsubarrays {
    PrintWriter out = new PrintWriter(System.out, true);

    // count subarrays with no dupes
    long countSubarrayWithNoDupes(int[] arr) {
        Set<Integer> vis = new HashSet<>();
        int n = arr.length;
        long res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n && !vis.contains(arr[j]); j++) {
                vis.add(arr[j]);
            }

            res += (j - i);

            vis.remove(arr[i]);
        }
    }

    // count subarrays with no dupe elements, ver 2
    long countSubarrayWithNoDupesAlt(int[] arr) {
        Set<Integer> vis = new HashSet<>();

        int n = arr.length;
        int i = 0;
        int j = 0;
        long res = 0;

        for (; j < n; j++) {
            while (vis.contains(arr[j]))
                vis.remove(arr[i++]);

            vis.add(arr[j]);

            res += (j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {

    }
}
