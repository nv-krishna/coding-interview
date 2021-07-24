# Is Symmetric Binary Tree

## Alias
- Leetcode (101): [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)

## Problem
- Check a binary tree is symmetric around its center or not.
- Return true if the binary trees is symmetric.

## Solutions
- Solution 1
  ```java
  public boolean isSymmetric(TreeNode root) {
      return isMirror(root.left, root.right);
  }

  public boolean isMirror(TreeNode t1, TreeNode t2) {
      if (t1 == null && t2 == null) return true;
      if (t1 == null || t2 == null) return false;
        
      // for t1: root -> left -> right    (Pre-order)
      // for t2: root -> right  -> left   (Pre-order's variation)
      return (t1.val == t2.val)
           && isMirror(t1.left, t2.right)
           && isMirror(t1.right, t2.left);           
  }
  ```
