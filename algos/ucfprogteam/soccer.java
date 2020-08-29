import java.util.*;
import java.io.*;

class soccer {
    static PrintWriter out = new PrintWriter(System.out, true);
    static int[] dirs = { 3, 1 };
    static List<String> pairs;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int g = in.nextInt();
        int p = in.nextInt();
        pairs = new ArrayList<>();

        go(g, p, 0, 0, 0, 0);
        for (String s : pairs)
            out.println(s);
    }

    static void go(int g, int p, int w, int t, int l, int idx) {
        if (p < 0 || g < 0)
            return;
        if (p == 0) {
            StringBuilder str = new StringBuilder();
            str.append(w);
            str.append("-");
            str.append(t);
            str.append("-");
            str.append(l + g);
            pairs.add(str.toString());
            return;
        }

        for (int i = idx; i < 2; i++) {
            if (p - dirs[i] >= 0) {

                if (i == 0)
                    go(g - 1, p - dirs[i], w + 1, t, l, i);
                else
                    go(g - 1, p - dirs[i], w, t + 1, l, i);
            }
        }

    }
}