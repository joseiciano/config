/*
 * @lc app=leetcode id=237 lang=java
 *
 * [237] Delete Node in a Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public void deleteNode(ListNode node) {
        PrintWriter out = new PrintWriter(System.out, true);

        if (node.next == null) {
            return;
        }
        if (node.next.next == null) {
            node.val = node.next.val;
            node.next = null;
            return;
        }

        while (node.next.next != null) {
            int nextval = node.next.val;
            node.val = nextval;
            node = node.next;
        }

        node.val = node.next.val;
        node.next = null;
    }
}
// @lc code=end
