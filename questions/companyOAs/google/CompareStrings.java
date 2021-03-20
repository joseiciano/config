import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/352458/

public class CompareStrings {
    static PrintWriter out = new PrintWriter(System.out, true);

    static class pair {
        char c;
        int f;

        public pair(char cc, int ff) {
            c = cc;
            f = ff;
        }

        public String toString() {
            return "(" + c + ", " + f + ")";
        }
    }

    static int binary(int[] wcount, int t) {
        int lo = 0;
        int hi = wcount.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (wcount[mid] <= t)
                lo = mid + 1;
            else
                hi = mid;
        }

        return wcount.length - lo;
    }

    static int search(int[] wcount, int t) {
        int count = 0;
        for (int i : wcount)
            if (i > t)
                count++;
        return count;
    }

    static int f(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        for (int i = 0; i < 26; i++)
            if (freq[i] > 0)
                return freq[i];
        return 0;
    }

    // words would be A, queries would be B
    static int[] solveOpt(String words, String queries) {
        String[] ws = words.split(",");
        String[] qs = queries.split(",");

        // Each index is the corresponding freq count of smallest character
        int[] wcount = new int[ws.length];
        for (int i = 0; i < ws.length; i++)
            wcount[i] = f(ws[i]);

        // We don't need the specific indexes, just the amounts, so we can sort
        Arrays.sort(wcount);

        // linear: O(qs * ws)
        // binary: O(qs * log(ws))
        int[] ret = new int[qs.length];
        for (int i = 0; i < qs.length; i++)
            // ret[i] = search(wcount, f(qs[i]));
            ret[i] = binary(wcount, f(qs[i]));

        return ret;
    }

    static int[] solve(String A, String B) {
        String[] aarr = A.split(",");
        String[] barr = B.split(",");

        Map<String, pair> amap = new HashMap<>();
        Map<String, pair> bmap = new HashMap<>();

        // O(aarr)
        for (String s : aarr) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++)
                freq[s.charAt(i) - 'a']++;

            char smallest = '{';
            int smallFreq = -1;

            for (int i = 0; i < 26; i++)
                if ((freq[i] > 0) && (smallest > (char) (i + 'a'))) {
                    smallest = (char) (i + 'a');
                    smallFreq = freq[i];
                }

            amap.put(s, new pair(smallest, smallFreq));
        }

        // O(barr)
        for (String s : barr) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++)
                freq[s.charAt(i) - 'a']++;

            char smallest = '{';
            int smallFreq = -1;

            for (int i = 0; i < 26; i++)
                if ((freq[i] > 0) && (smallest > (char) (i + 'a'))) {
                    smallest = (char) (i + 'a');
                    smallFreq = freq[i];
                }

            bmap.put(s, new pair(smallest, smallFreq));
        }

        int[] ret = new int[barr.length];
        int i = 0;
        // O(barr*aarr)
        for (String s : barr) {
            for (String a : aarr)
                if (amap.get(a).f < bmap.get(s).f)
                    ret[i]++;
            i++;
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        String a = "abcd,aabc,bd";
        String b = "aaa,aa";

        out.println(Arrays.toString(solve(a, b)));
        a = "";
        b = "";
    }
}