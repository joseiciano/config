import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

/*
* 
* Idea: Find the intersection
* 
* Cases:
* 
* 1. A = |================|
* 
* --------B = |=======|
* 
* 2. A = |================|
* 
* -----------------B = |==========|
* 
* 3. A = |==================|
* 
* ----------------------B = |=========|
* 
* 4. A = |==========|
* 
* ---------------------B = |=========|
* 
* We only care about cases 1-3 since there's intersection The intersection, C,
* = Max(A.start, B.start) - Min(A.end, B.end)
* 
* In case 4, this is where lo <= hi comes in because if we find C, we get (lo,
* hi) where lo > hi since lo = B.start, hi = A.end
*/

// @lc code=start
class Solution {
    PrintWriter out = new PrintWriter(System.out, true);

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> intersection = new ArrayList<>();

        for (int i = 0, j = 0; i < A.length && j < B.length;) {
            int[] a = A[i];
            int[] b = B[j];

            int lo = Math.max(a[0], b[0]);
            int hi = Math.min(a[1], b[1]);

            if (lo <= hi)
                intersection.add(new int[] { lo, hi });
            if (a[1] < b[1])
                i++;
            else
                j++;

        }

        return intersection.toArray(new int[intersection.size()][]);
    }
}
// @lc code=end
