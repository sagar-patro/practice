package com.practice.sp.solutions;

import static java.lang.System.out;

/**
 * Leetcode# 104
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthBinaryTree {

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = 1;
        int right = 1;

        if(root.left != null) {
            left = 1 + maxDepth(root.left);
        }
        if(root.right != null) {
            right = 1 + maxDepth(root.right);
        }

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        /*Integer[] nodes = {3, 9, 20, null, null, 15, 7};*/
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9, null, null);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        out.println(maxDepth(root)); //output should be 3
    }
}
