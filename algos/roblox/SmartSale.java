import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/853151/Roblox-New-Grad-Online-Assessment-Questions
public class SmartSale {
    static PrintWriter out = new PrintWriter(System.out, true);

    static int go(int n, int m, int[] ids) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int id : ids)
            map.put(id, map.getOrDefault(id, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int id : ids)
            pq.offer(id);

        while (!pq.isEmpty() && m > 0) {
            int cur = pq.poll();

            if (map.get(cur) > m)
                break;

            m -= map.get(cur);
            map.remove(cur);
        }

        return map.size();
    }

    public static void main(String[] args) throws Exception {
        int n = 6;
        int m = 2;
        int[] ids = { 1, 1, 1, 2, 2, 3 };
        out.println(go(n, m, ids)); // 2

        n = 6;
        m = 3;
        ids = new int[] { 1, 2, 3, 1, 2, 2 };
        out.println(go(n, m, ids)); // 1
    }
}
