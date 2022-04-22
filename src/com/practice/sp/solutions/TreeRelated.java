package com.practice.sp.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.System.*;

public class TreeRelated {

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

          @Override
          public String toString() {
              return "TreeNode{" +
                      "val=" + val +
                      ", left=" + left +
                      ", right=" + right +
                      '}';
          }
      }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int range = q.size();

            List<Integer> level = new ArrayList<>();
            while(range-- != 0) {
                TreeNode node = q.poll();
                level.add(node.val);

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            result.add(level);
        }
        return result;
    }

    /**
     * Leetcode# 235
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode tmp = root;
        while(true) {
            if(p.val > tmp.val && q.val > tmp.val) {
                tmp = tmp.right;
            } else if(p.val < tmp.val && q.val < tmp.val) {
                tmp = tmp.left;
            } else return tmp;
        }
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(3, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, left, right);

        out.println(levelOrder(root));

        TreeNode node = new TreeNode(
                6,
                new TreeNode(
                        2,
                        new TreeNode(0),
                        new TreeNode(
                                4,
                                new TreeNode(3),
                                new TreeNode(5)
                        )
                ),
                new TreeNode(
                        8,
                        new TreeNode(7),
                        new TreeNode(9)
                )
        );

        out.println(
                lowestCommonAncestor(node, new TreeNode(7), new TreeNode(8))
        );

    }
}
