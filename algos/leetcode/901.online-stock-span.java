import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=901 lang=java
 *
 * [901] Online Stock Span
 */

// @lc code=start
class StockSpanner {

    class pair {
        int v;
        int f;

        public pair(int vv, int ff) {
            v = vv;
            f = ff;
        }
    }

    Deque<pair> s;

    public StockSpanner() {
        s = new ArrayDeque<>();
    }

    public int next(int price) {
        int gt = 1;

        while (!s.isEmpty() && s.peekLast().v <= price) {
            gt += s.pollLast().f;
        }

        s.offer(new pair(price, gt));
        return gt;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner(); int param_1 = obj.next(price);
 */
// @lc code=end
