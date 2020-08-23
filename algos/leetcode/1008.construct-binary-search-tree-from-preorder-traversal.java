/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 import java.util.*;
 import java.io.*;
 

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        int n = preorder.length;
        int end = n;

        for (int i = 1; i < n; i++) {
            if (preorder[i] > root.val) {
                end = i;
                break;
            }
        }

        int[] left = new int[end-1];
        for (int i = 1, k = 0; i < end; i++, k++)
            left[k] = preorder[i];

        int[] right = new int[n-end];
        for (int i = end, k = 0; i < n; i++, k++)
            right[k] = preorder[i];
        
        root.left = bstFromPreorder(left);
        root.right = bstFromPreorder(right);
        
        return root;
    }
}
// @lc code=end

