import java.util.*;
import java.io.*;

public class sushi {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt(); // no of cars

        PriorityQueue<Integer> cars = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < c; i++)
            cars.add(in.nextInt());

        PriorityQueue<Integer> speeds = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 4 * c; i++)
            speeds.add(in.nextInt());

        int time = 0;
        while (!cars.isEmpty()) {
            int car = cars.poll();
            int max = -1;
            for (int i = 0; i < Math.min(4, speeds.size()); i++)
                max = Math.max(max, speeds.poll());
            time = Math.max(time, car + max);
        }

        out.println(time);

    }
}