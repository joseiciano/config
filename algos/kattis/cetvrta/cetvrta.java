import java.util.*;
import java.io.*;

public class cetvrta {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        Map<Integer, Integer> top = new HashMap<>();
        Map<Integer, Integer> bot = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            top.put(x, top.getOrDefault(x, 0) + 1);
            bot.put(y, bot.getOrDefault(y, 0) + 1);
        }

        int x1 = 0;
        int x2 = 0;
        for (Integer key : top.keySet()) {
            if (top.get(key) == 1)
                x1 = key;
        }

        for (Integer key : bot.keySet()) {
            if (bot.get(key) == 1)
                x2 = key;
        }

        out.println(x1 + " " + x2);
    }
}