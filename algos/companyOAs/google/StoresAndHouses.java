import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/350248/Google-or-Summer-Intern-OA-2019-or-Stores-and-Houses

public class StoresAndHouses {

    static PrintWriter out = new PrintWriter(System.out, true);

    static int[] solve(int[] houses, int[] stores) {
        int n = houses.length;
        int[] ret = new int[n];

        TreeSet<Integer> closestStores = new TreeSet<>();

        for (int store : stores)
            closestStores.add(store);

        for (int i = 0; i < n; i++) {
            Integer ceil = closestStores.ceiling(houses[i]);
            Integer floor = closestStores.floor(houses[i]);

            if (ceil == null || (ceil - houses[i]) >= (houses[i] - floor))
                ret[i] = floor;
            else
                ret[i] = ceil;

        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        int[] stores = new int[] { 2, 4, 2 };
        int[] houses = new int[] { 5, 1, 2, 3 };
        out.println(Arrays.toString(solve(stores, houses))); // [2, 3, 2]

        stores = new int[] { 4, 8, 1, 1 };
        houses = new int[] { 5, 3, 1, 2, 6 };
        out.println(Arrays.toString(solve(stores, houses))); // [3, 6, 1, 1]
    }
}