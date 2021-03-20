/*
    Author: Jose Iciano
    Problem: sameletters
*/

import java.util.*;
import java.io.*;

public class sameletters {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String file) throws Exception {
            br = new BufferedReader(new BufferedReader(new FileReader(file)));
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static final PrintWriter out = new PrintWriter(System.out, true);
    static FastScanner in;
    static final int oo = (int) 1e9;
    static final int MOD = (int) 1e9 + 7;
    static int i;

    public static void main(String[] args) throws Exception {
        in = new FastScanner();
        // in = new FastScanner("sameletters");

        String a = in.next();
        String b = in.next();

        i = 1;
        while (!a.equals("END") && !b.equals("END")) {
            solve(a, b);
            a = in.next();
            b = in.next();
        }
    }

    static void solve(String a, String b) throws Exception {
        int[] count = new int[26];
        boolean g = true;

        for (char c : a.toCharArray())
            count[c - 'a']++;
        for (char c : b.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0)
                g = false;
        }

        out.println("Case " + (i++) + ": " + (g ? "same" : "different"));
    }
}