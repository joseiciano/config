import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/848711/Roblox-New-Grad-OA
public class SortRoman {
    static PrintWriter out = new PrintWriter(System.out, true);

    static void sort(int n, String[] names) {
        Arrays.sort(names, (a, b) -> {

        });
    }

    public static void main(String[] args) throws Exception {
        int n = 2;
        String[] names = {"Louis IX", "Louis VIII"};
        sort(n, names);
        for (String name : names)
            out.println(name); // Louis IX, Louis VIII

        n = 2;
        names = new String[]{"Philip II", "Philippe I"};
        sort(n, names);
        for (String name : names)
            out.println(name); // Philip II, Philippe I
    }
}
