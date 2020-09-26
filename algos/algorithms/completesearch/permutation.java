import java.util.*;
import java.io.*;

public class permutation {

    List<List<Integer>> permutations = new ArrayList<>();

    void search(List<Integer> curperm, boolean[] used, int n) {
        if (curperm.size() == n) {
            permutations.add(new ArrayList<>(curperm));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                curperm.add(i);
                search(curperm, used, n);
                curperm..remove(curperm.size()-1);
                used[i] = false;
            }
        }
    }
}
