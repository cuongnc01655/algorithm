package main.java.leetcode.tree;

import java.util.Stack;

public class ValidBST {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {

    }

    boolean isValidBST(TreeNode node) {
        double inOrder = -Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val <= inOrder) return false;
            inOrder = node.val;
            node = node.right;
        }
        return false;
    }
}
