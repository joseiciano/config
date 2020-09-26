import java.util.*;
import java.io.*;

class closestsums {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);
        // Scanner in = new Scanner(new File("closestsums.in"));
        int oo = (int) 1e9;

        boolean flag = true;
        int cases = 0;
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            cases++;
            out.println("Case " + cases + ":");

            Arrays.sort(nums);
            int m = in.nextInt();
            for (int i = 0; i < m; i++) {
                int q = in.nextInt();

                int lo = 0;
                int hi = n - 1;
                int close = oo;
                while (lo < hi) {
                    int sum = nums[lo] + nums[hi];

                    // out.println(nums[lo] + " " + nums[hi] + " = " + sum);
                    if (Math.abs(q - sum) < Math.abs(q - close)) {
                        close = sum;
                    }

                    if (sum == q) {
                        break;
                    } else if (sum > q) {
                        hi--;
                    } else {
                        lo++;
                    }
                }

                out.println("Closest sum to " + q + " is " + close + ".");

            }
        }
    }
}