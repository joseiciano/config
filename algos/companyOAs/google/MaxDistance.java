import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/350363/Google-or-OA-2018-or-Max-Distance

/*
    Idea:
        If you make a tri out of each list, you will see points that branch into nonempty subtrees

        If you take the sum of left and right nonempty subtree, that is a potential maxdiff
        Create a tri and insert all strings

        Compare each branch point and check with maxdiff, return the greatest
*/

public class MaxDistance {
    static PrintWriter out = new PrintWriter(System.out, true);

    static class tri {
        tri[] children;
        boolean isword;
        int maxdiff;
        int val;

        public tri(char c) {
            children = new tri[2];
            isword = false;
            maxdiff = 0;
            val = c - '0';
        }

        void add(ArrayList<String> bins) {
            for (String bin : bins) {
                tri cur = this;

                for (char c : bin.toCharArray()) {
                    if (cur.children[c - '0'] == null) {
                        cur.children[c - '0'] = new tri(c);
                    }
                    cur = cur.children[c - '0'];
                }

                isword = true;
            }
        }

        int dfs(tri root) {
            if (root == null)
                return 0;

            int left = dfs(root.children[0]);
            int right = dfs(root.children[1]);

            if (left > 0 && right > 0) {
                maxdiff = Math.max(maxdiff, left + right);
            }

            return 1 + Math.max(left, right);
        }
    }

    static int solve(ArrayList<String> bins) {
        tri root = new tri('#');
        root.add(bins);
        root.dfs(root);
        return root.maxdiff;
    }

    public static void main(String[] args) throws Exception {
        out.println(solve(new ArrayList<String>(Arrays.asList("1011100", "1011011", "1001111")))); // 10
        out.println(solve(new ArrayList<String>(Arrays.asList("1011100", "1011110")))); // 6
    }
}