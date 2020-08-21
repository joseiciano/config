import java.util.*;
import java.io.*;

public class modulo {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        Set<Integer> mod = new HashSet<>();
        for (int i = 0; i < 10; i++)
            mod.add(in.nextInt() % 42);

        System.out.println(mod.size());
    }
}