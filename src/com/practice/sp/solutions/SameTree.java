package com.practice.sp.solutions;

import static java.lang.System.*;

public class SameTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Leetcode$ 572
     * https://leetcode.com/problems/subtree-of-another-tree/
     */
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;

        if(isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode right = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        out.println(isSameTree(left, right)); //Should return true
    }
}
