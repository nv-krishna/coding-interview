# Is Same Binary Trees

## Alias
- Leetcode (100): [Same Tree](https://leetcode.com/problems/same-tree/)

## Problem
- Check 2 binary trees are same or not.
- Return true if 2 binary trees are same.

## Solutions
- Solution 1
  ```java
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
