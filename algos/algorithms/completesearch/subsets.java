import java.util.*;
import java.io.*;

public class subsets {

    // Generates subsets from 0 to n,
    // k is initially 0
    List<List<Integer>> sets = new ArrayList<>();

    void search(int k, int n, List<Integer> subset) {
        if (k == n) {
            sets.add(new ArrayList<>(subset));
            return;
        } else {
            search(k + 1, n, subset);
            subset.add(k);
            search(k + 1, n, subset);
            subset.remove(subset.size() - 1);
        }
    }

    void search(int n) {
        int setno = 1 << n;
        for (int mask = 0; mask < setno; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0)
                    subset.add(n);
            }
            sets.add(subset);
        }
    }
}
