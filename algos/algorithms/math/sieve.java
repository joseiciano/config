import java.util.*;
import java.io.*;

/*
    Generate a list from 0 to n of prime numbers
*/
class sieve {

    boolean[] prime(int n) {
        boolean[] isPrime = new boolean[n + 1]; // a[i] = true if prime
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++)
            for (int j = 2 * i; j <= n; j += i)
                isPrime[j] = false;

        return isPrime;
    }

    boolean[] primeop(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= (int) Math.sqrt(n); i++) {
            if (!isPrime[i])
                continue;
            for (int j = 2 * i; j <= n; j += i)
                isPrime[j] = false;
        }

        return isPrime;
    }

    public static void main(String[] args) throws Exception {

    }
}