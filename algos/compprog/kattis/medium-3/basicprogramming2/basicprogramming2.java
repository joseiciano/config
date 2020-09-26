import java.util.*;
import java.io.*;

public class basicprogramming2 {
    static PrintWriter out = new PrintWriter(System.out, true);

    static boolean twosum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr)
            set.add(num);

        for (int num : arr) {
            if (set.contains(target - num))
                return true;
        }

        return false;
    }

    static boolean unique(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr)
            set.add(num);
        return set.size() == arr.length;
    }

    static int getmode(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        int max = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > (arr.length / 2))
                max = entry.getKey();
        }

        return max;
    }

    static int[] median(int[] arr) {
        int n = arr.length;

        int[] med = new int[n % 2 == 0 ? 2 : 1];

        if (n % 2 == 0) {
            med[0] = arr[(n - 1) / 2];
            med[1] = arr[n / 2];
        } else {
            med[0] = arr[n / 2];
        }

        return med;
    }

    static List<Integer> inrange(int[] arr, int lo, int hi) {
        List<Integer> ret = new ArrayList<>();

        for (int num : arr)
            if (lo <= num && num <= hi)
                ret.add(num);

        return ret;
    }

    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();

        int n = in.nextInt();
        int t = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        Arrays.sort(arr);

        if (t == 1) {
            boolean res = twosum(arr, 7777);
            out.println(res ? "Yes" : "No");
        } else if (t == 2) {
            boolean res = unique(arr);
            out.println(res ? "Unique" : "Contains duplicate");
        } else if (t == 3) {
            int mode = getmode(arr);
            out.println(mode);
        } else if (t == 4) {
            int[] med = median(arr);
            out.println((med.length == 1) ? med[0] : med[0] + " " + med[1]);
        } else if (t == 5) {
            List<Integer> range = inrange(arr, 100, 999);
            for (int i = 0; i < range.size(); i++) {
                if (i + 1 == range.size())
                    out.println(range.get(i));
                else
                    out.print(range.get(i) + " ");
            }
        }
    }
}

class FastScanner {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public FastScanner() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public FastScanner(String filename) throws Exception {
        din = new DataInputStream(new FileInputStream(filename));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws Exception {
        byte[] buf = new byte[64];
        int cin = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n')
                break;
            buf[cin++] = (byte) c;
        }
        return new String(buf, 0, cin);
    }

    public int nextInt() throws Exception {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        return ret * (neg ? -1 : 1);
    }

    public long nextLong() throws Exception {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        return ret * (neg ? -1 : 1);
    }

    public double nextDouble() throws Exception {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }
        return ret * (neg ? -1 : 1);
    }

    private void fillBuffer() throws Exception {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws Exception {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws Exception {
        if (din != null)
            din.close();
    }
}
