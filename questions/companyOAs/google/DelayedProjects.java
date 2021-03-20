import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/397524/

class DelayedProjects {
    static PrintWriter out = new PrintWriter(System.out, true);
    static Scanner in;

    static List<String> solve(String[][] l, int k, String[] d, int j) {
        Set<String> delayed = new HashSet<>();
        Set<String> ret = new HashSet<>();

        for (String dd : d) {
            delayed.add(dd);
        }

        Map<String, ArrayList<String>> g = new HashMap<>();
        Deque<String> q = new ArrayDeque<>();

        for (String[] ll : l) {
            if (!g.containsKey(ll[0]))
                g.put(ll[0], new ArrayList<>());
            if (!g.containsKey(ll[1]))
                g.put(ll[1], new ArrayList<>());

            g.get(ll[1]).add(ll[0]);

            if (delayed.contains(ll[1]))
                q.addLast(ll[0]);
        }

        while (!q.isEmpty()) {
            String cur = q.pollFirst();

            for (String s : g.get(cur)) {
                if (!ret.contains(s)) {
                    q.offerLast(s);
                    ret.add(s);
                }
            }
        }

        ret.addAll(delayed);
        return new ArrayList<String>(ret);
    }

    // static List<String> solve(String[][] l, int k, String[] d, int j) {

    // Set<String> delayed = new HashSet<>();
    // Set<String> ret = new HashSet<>();

    // for (String dd : d)
    // delayed.add(dd);

    // Map<String, ArrayList<String>> g = new HashMap<>();
    // for (String[] ll : l) {
    // if (!g.containsKey(ll[0]))
    // g.put(ll[0], new ArrayList<>());
    // g.get(ll[0]).add(ll[1]);

    // if (delayed.contains(ll[1]))
    // ret.add(ll[0]);
    // }

    // ret.addAll(delayed);

    // return new ArrayList<String>(ret);
    // }

    public static void main(String[] args) throws Exception {
        // Sample output
        /*
         * Case #1: B C Case #2: P Q S Case #3: B C D F G
         */
        in = new Scanner(new File("DelayedProjects.in"));

        int testcases = in.nextInt();

        for (int t = 1; t <= testcases; t++) {
            int k = in.nextInt();
            int j = in.nextInt();

            String[][] l = new String[k][2];
            for (int i = 1; i <= k; i++) {
                l[i - 1][0] = in.next();
                l[i - 1][1] = in.next();
            }

            String[] d = new String[j];
            for (int i = 1; i <= j; i++) {
                d[i - 1] = in.next();
            }

            List<String> dependencies = solve(l, k, d, j);
            out.print("Case #" + t + ":");
            for (String dep : dependencies)
                out.print(" " + dep);
            out.println();
        }
    }
}