import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/356520
public class MinNumberOfChairs {
    static PrintWriter out = new PrintWriter(System.out, true);

    static class pair {
        int s;
        int e;

        public pair(int start, int end) {
            s = start;
            e = end;
        }
    }

    // O(nlogn) time
    // O(n) space
    static int solve(int[] s, int[] e) {
        int n = s.length;
        pair[] intervals = new pair[n];

        for (int i = 0; i < n; i++)
            intervals[i] = new pair(s[i], e[i]);

        Arrays.sort(intervals, (a, b) -> a.s - b.s);
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.e - b.e); // Holds min chairs needed after simulation
        pq.offer(intervals[0]);

        for (int i = 1; i < n; i++) {
            pair p = intervals[i];

            // Current time interval does not intersect with the previous, so no extra
            // chairs needed
            if (p.s >= pq.peek().e) {
                pq.poll();
                pq.offer(p);
            }
            // They intersect
            else {
                pq.offer(p);
            }
        }

        return pq.size();
    }

    // O(n) time
    // O(max(s)) space
    static int solveOpt(int[] s, int[] e) {
        int max = 0;
        for (int t : s)
            max = Math.max(max, t);

        int[] times = new int[max + 1];

        for (int t : s)
            times[t]++;

        for (int t : e)
            if (t <= max)
                times[t]--;

        int chairs = 0;
        int minChairs = 0;
        for (int t : times) {
            chairs += t;
            minChairs = Math.max(minChairs, chairs);
        }

        return minChairs;
    }

    // O(nlogn) time
    // O(n) space
    static int solveFancy(int[] s, int[] e) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int t : s)
            map.put(t, map.getOrDefault(t, 0) + 1);
        for (int t : e)
            map.put(t, map.getOrDefault(t, 0) - 1);

        int chair = 0;
        int maxchairs = 0;
        for (int k : map.keySet()) {
            chair += map.get(k);
            maxchairs = Math.max(chair, maxchairs);
        }

        return maxchairs;
    }

    public static void main(String[] args) throws Exception {
        int[] s = new int[] { 1, 2, 6, 5, 3 };
        int[] e = new int[] { 5, 5, 7, 6, 8 };

        out.println(solveFancy(s, e)); // 3
    }
}