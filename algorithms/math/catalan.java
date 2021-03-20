import java.util.*;
import java.io.*;
import java.math.*;

public class catalan {
    // List<Long> memo;
    BigInteger[] memo;

    public catalan() {
        memo = new BigInteger[10000];
        memo[0] = new BigInteger("1");
        memo[1] = new BigInteger("1");
    }

    BigInteger getCatalan(int n) {
        if (memo[n] != null)
            return memo[n];

        // C(n+1) = 2*2(n-1)/(n-1) * Cn
        BigInteger res = BigInteger.valueOf(2 * (2 * n - 1)).multiply(getCatalan(n - 1))
                .divide(BigInteger.valueOf(n + 1));
        return memo[n] = res;
    }
}
