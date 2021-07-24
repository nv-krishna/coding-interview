# Get Closest Value to Target from Binary Search Tree

## Alias
- Leetcode (270): [Closest Binary Search Tree Value](https://leetcode.com/problems/closest-binary-search-tree-value/)

## Problem
- Get the value from a binary search tree which is closest to the target value.

## Solutions
- Solution 1
  ```java
  class Solution {
      private int    closestValue = Integer.MAX_VALUE;
      private double delta        = Double.MAX_VALUE;
    
      public int closestValue(TreeNode root, double target) {
          traverse (root, target);
          return this.closestValue;
      }
    
      public void traverse (TreeNode node, double target) {
          if (node == null) return;
        
          if (Math.abs(node.val - target) < delta) {
              this.closestValue = node.val;
              this.delta = Math.abs(node.val - target);
          }
        
          traverse(node.left, target);
          traverse(node.right, target);
      }
  }
  ```
