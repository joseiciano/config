import java.util.*;
import java.io.*;

public class peasoup {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        // Scanner in = new Scanner(new File("peasoup.in"));
        PrintWriter out = new PrintWriter(System.out, true);

        int n = Integer.parseInt(in.nextLine().strip());

        boolean pc = false;
        boolean ps = false;
        boolean f = false;
        String name = "";

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(in.nextLine().strip());
            pc = ps = false;

            name = in.nextLine().strip();
            for (int j = 0; j < k; j++) {
                String food = in.nextLine().strip();
                if (food.equals("pea soup"))
                    pc = true;
                if (food.equals("pancakes"))
                    ps = true;
            }

            if (pc && ps) {
                f = true;
                break;
            }
        }

        out.println((f) ? name : "Anywhere is fine I guess");
    }
}