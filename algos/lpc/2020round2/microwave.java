import java.util.*;
import java.io.*;

class FastScanner {

    BufferedReader br;
    StringTokenizer st;

    public FastScanner(String file) throws Exception {
        br = new BufferedReader(new BufferedReader(new FileReader(file)));
    }

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}


public class microwave {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();
        // FastScanner in = new FastScanner("in.txt");

        String time = in.next();

        String[] split = time.split(":");
        long hours = Long.parseLong(split[0]) * 60 * 60;
        Long mins = Long.parseLong(split[1]) * 60;

        Long sec = hours + mins;
        Long expected = Long.parseLong(split[0])*60 + Long.parseLong(split[1]);

        Long diff = sec - expected;
        Long hour = 0l;
        Long min = diff / 60;
         sec = diff % 60;
         
        if (min >= 60) {
            hour = min / 60;
            min = min % 60;
            
        }

        char[] fin = new char[8];
        fin[2] = fin[5] = ':';

        if (hour >= 10) {
            fin[0] = (char)((hour / 10)+'0');
            fin[1] = (char)((hour % 10)+'0');
        }
        else {
            fin[0] = '0';
            fin[1] = (char)(hour + '0');
        }

        if (min >= 10) {
            fin[3] = (char)((min / 10) + '0');
            fin[4] = (char)((min % 10) + '0');

        }
        else {
            fin[3] = '0';
            fin[4] = (char)(min+'0');
        }

        if (sec >= 10) {
            fin[6] = (char)((sec / 10) + '0');
            fin[7] = (char)((sec % 10) + '0');
        }
        else {
            fin[6] = '0';
            fin[7] = (char)((sec)+'0');
        }
        out.println(new String(fin));
    }

    static int num(char c) {
        return (char)(c + '0');
    }
}
