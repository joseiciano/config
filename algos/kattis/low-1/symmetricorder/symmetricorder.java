import java.util.*;
import java.io.*;

public class symmetricorder {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        int n = in.nextInt();
        int set = 0;
        while (n != 0) {
            set++;
            String[] names = new String[n];

            for (int i = 0; i < n; i++) {
                names[i] = in.next();
            }

            String[] fin = new String[n];
            for (int i = 0, j = 0; i < n; i += 2, j++)
                fin[j] = names[i];

            for (int i = 1, j = n - 1; i < n; i += 2, j--) {
                fin[j] = names[i];
            }

            out.println("SET " + set);
            for (String f : fin)
                out.println(f);
            n = in.nextInt();
        }

    }
}