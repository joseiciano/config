import java.util.*;
import java.io.*;

public class quickselect {

    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        out.println(qselect(new int[] { 5, 2, 9, 6, 1, 3, 8 }, 0, 6, 4)); // 5
    }

    static int qselect(int[] nums, int lo, int hi, int k) {
        // Base case: Only number in search range
        if (lo == hi)
            return nums[lo];

        // Get partition index randomly and partition around it
        int pivot = lo + (int) (Math.random() * (hi - lo + 1));
        pivot = partition(nums, lo, hi, hi);

        // Partition element is corrent k val, so return
        if (k == pivot)
            return nums[k];

        // Looking for smaller element than partition
        else if (k < pivot)
            return qselect(nums, lo, pivot - 1, k);

        // Looking for greater element than partition
        else
            return qselect(nums, pivot + 1, hi, k - (hi - lo + 1));
    }

    static int partition(int[] nums, int lo, int hi, int pivotidx) {
        int pivot = nums[pivotidx];

        // Swap pivot into hi idx
        swap(nums, pivotidx, hi);

        // Everything upto store is less than pivot
        // Everything after store is greater than/equal
        int store = lo;

        for (int i = lo; i <= hi; i++) {
            if (nums[i] < pivot) {
                swap(nums, store, i);
                store++;
            }
        }

        // Swap pivot into final position
        swap(nums, store, hi);

        return store;
    }

    static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}