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

public class b {
    static PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();
        // FastScanner in = new FastScanner("in.txt");
        // Scanner in = new Scanner(new File("in.txt"));

        int t = in.nextInt();
        int candidate = 0;
        int electoral = 0;
        boolean wonelec = true;
        boolean woncan = true;
        for (int te = 0; te < t; te++) {
            int e = in.nextInt();
            int c1 = in.nextInt();
            int c2 = in.nextInt();

            if (c1 > c2)
                electoral += e;
            else if (c1 < c2)
                electoral -= e;

            candidate += c1;
            candidate -= c2;
        }

        if (candidate > 0 && electoral > 0)
            out.println(1);
        else if (candidate < 0 && electoral < 0)
            out.println(2);
        else out.println(0);

    }
}
