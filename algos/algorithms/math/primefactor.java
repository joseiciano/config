import java.util.*;
import java.io.*;

public class primefactor {

    class pair {
        public int prime;
        public int exp;

        public pair(int p, int e) {
            prime = p;
            exp = e;
        }
    }

    ArrayList<pair> primefac(int n) {
        ArrayList<pair> res = new ArrayList<>();

        // Keep going till left with a prime
        for (int div = 2; div * div <= n; div++) {
            int exp = 0;
            while (n % div == 0) {
                n /= div;
                exp++;
            }

            // if it is a divisor, add
            if (exp > 0)
                res.add(new pair(div, exp));
            div++;
        }

        if (n > 1)
            res.add(new pair(n, 1));

        return res;
    }

    public static void main(String[] args) throws Exception {

    }
}