# Invert Binary Tree

## Alias
- Leetcode (226): [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)

## Problem
- Invert a binary tree (swap the left child and right child of each node).
- Return the root of the new binary tree.

## Solutions
- Solution 1
  ```java
  public TreeNode invertBinaryTree(TreeNode root) {
      if (root == null) return null;
        
      invertTree(root.left);
      invertTree(root.right);
        
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
        
      return root;
 }
  ```
