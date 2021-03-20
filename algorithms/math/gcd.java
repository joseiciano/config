import java.util.*;
import java.io.*;

public class gcd {

    int getgcdit(int a, int b) {
        while (b != 0) {
            a = b;
            b = a % b;
        }
        return a;
    }

    int getgcd(int a, int b) {
        return b == 0 ? a : getgcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {

    }
}