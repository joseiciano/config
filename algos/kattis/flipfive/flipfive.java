import java.util.*;
import java.io.*;

class flipfive {
    // static Scanner in = new Scanner(System.in);
    static Scanner in;
    static PrintWriter out;
    static Map<Integer, Integer> map = new HashMap<>();

    static int oo = (int) 1e9;

    public static void main(String[] args) throws Exception {
        in = new Scanner(System.in);
        // in = new Scanner(new File("flipfive.in"));
        out = new PrintWriter(System.out, true);

        bfs();

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < 3; j++)
                str.append(in.next());
            String find = str.toString();

            int num = 0;
            for (int j = 0; j < 9; j++)
                if (find.charAt(j) == '*')
                    num ^= (1 << j);

            out.println(map.get(num));
        }
    }

    static boolean isin(int r, int c) {
        return 0 <= r && r < 3 && 0 <= c && c < 3;
    }

    static int getneighbor(int r, int c) {
        return (isin(r, c) ? 3 * r + c : oo);
    }

    static int flip(int num, int r, int c) {
        int[] neighbors = { getneighbor(r, c - 1), getneighbor(r, c + 1), getneighbor(r - 1, c),
                getneighbor(r + 1, c) };

        int newnum = num;
        for (int neighbor : neighbors)
            if (neighbor != oo)
                newnum ^= (1 << neighbor);

        newnum ^= (1 << (3 * r + c));

        return newnum;
    }

    static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> vis = new HashSet<>();
        q.offerLast(000000000);
        map.put(000000000, 0);
        vis.add(0);

        int ways = -1;
        while (!q.isEmpty()) {
            ways++;
            int level = q.size();

            for (int lev = 0; lev < level; lev++) {
                int cur = q.pollFirst();

                map.put(cur, ways);

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int next = flip(cur, i, j);
                        if (!vis.contains(next)) {
                            vis.add(next);
                            q.offerLast(next);
                        }
                    }
                }

            }
        }
    }
}