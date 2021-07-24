# Is Sub Binary Trees

## Alias
- Leetcode (572): [Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/)

## Problem
- Check one binary tree is a sub-tree of another binary tree.
- A binary tree could also be considered as a subtree of itself.

## Solutions
- Solution 1
  ```java
  public boolean isSubtree(TreeNode s, TreeNode t) {
      if (s == null) {
          return false;
      } 
        
      if (s.val == t.val && isSameTree(s, t)) {                           // If s.val = t.val, also s and t are same tree, return true                    
          return true;
      } else {                                                            // Check t can match the s left subtree or the s right subtree
          return isSubtree(s.left, t) || isSubtree(s.right, t);
      }
  }
    
  public boolean isSameTree(TreeNode t1, TreeNode t2) {
      if (t1 == null && t2 == null) {      // t1 and t2 are both null
          return true;
      } 
      if (t1 == null || t2 == null) {      // one of t1 and t2 is null
          return false;
      }
      
      if (t1.val != t2.val) {
          return false;
      } else {
          return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
      }
  }
  ```
