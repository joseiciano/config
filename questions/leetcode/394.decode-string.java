import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";

        StringBuilder str = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == ']')
                process(stack);
            else
                stack.add(c);
        }

        while (!stack.isEmpty())
            str.append(stack.pollFirst());

        return str.toString();
    }

    void process(Deque<Character> stack) {
        StringBuilder str = new StringBuilder();

        while (!stack.isEmpty() && stack.peekLast() != '[') {
            str.append(stack.pollLast());
        }

        stack.pollLast();

        StringBuilder count = new StringBuilder();
        while (!stack.isEmpty() && Character.isDigit(stack.peekLast())) {
            count.append(stack.pollLast());
        }

        count.reverse();
        str.reverse();
        String s = str.toString();

        s = s.repeat(Integer.parseInt(count.toString()));

        for (char c : s.toCharArray())
            stack.offerLast(c);
    }
}
// @lc code=end
