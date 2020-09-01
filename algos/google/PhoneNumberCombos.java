import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/229133/Google-or-Phone-or-Phone-number-combinations

public class PhoneNumberCombos {
    static PrintWriter out = new PrintWriter(System.out, true);

    static Map<Integer, List<Integer>> map = Map.of(1, Arrays.asList(2, 3, 4, 7), 2, Arrays.asList(1, 3, 5, 8), 3,
            Arrays.asList(1, 2, 6, 9), 4, Arrays.asList(1, 7, 5, 6), 5, Arrays.asList(2, 8, 4, 6), 6,
            Arrays.asList(4, 5, 3, 9), 7, Arrays.asList(1, 4, 8, 9), 8, Arrays.asList(2, 5, 7, 9), 9,
            Arrays.asList(7, 8, 3, 6));

    static void solve(List<List<Integer>> ret, List<Integer> cur) {
        if (cur.size() == 7) {
            ret.add(new ArrayList<>(cur));
            return;
        }

        for (int next : map.get(cur.get(cur.size() - 1))) {
            cur.add(next);
            solve(ret, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> cur = new ArrayList<>(Arrays.asList(4));
        solve(ret, cur);
        out.println(ret.size());
    }
}
