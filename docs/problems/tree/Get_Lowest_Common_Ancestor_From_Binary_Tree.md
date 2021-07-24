# Get Lowest Common Ancestor from Binary Tree

## Alias
- Leetcode (236): [Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

## Problem
- Get the lowest common ancestor (LCA) of two nodes in a binary tree.

## Solutions
- Solution 1
  ```java
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null) {
          return null;
      }
        
      if (root == p || root == q) return root;                  // If the current node is one of p or q (it means that p and q are up-down relationship)
                                                                // Return the current node.
                                                                   
      boolean isPInLeft = isNodeInTree(root.left, p);           // Check the p is in left sub-tree or not
      boolean isQInleft = isNodeInTree(root.left, q);           // Check the q is in left sub-tree or not
        
      if (isPInLeft != isQInleft) {                             // If p and q are in different sub-trees
          return root;                                          // So the current node is the LCA
      } else {
          if (isPInLeft && isQInleft) {                         // If both p and q are in the left sub-tree.
              return lowestCommonAncestor(root.left, p, q);     // Go to the left sub-tree
          } else {                                              // If both p and q are in the right sub-tree.
              return lowestCommonAncestor(root.right, p, q);    // Go to the right sub-tree
          }
      }
  }
  
  // Check the node is in the binary tree or not
  public boolean isNodeInTree(TreeNode root, TreeNode node) {
      if (root == null) return false;
        
      if (root == node) {
          return true;
      } else {
          return isNodeInTree(root.left, node) || isNodeInTree(root.right, node);
      }
  }
  ```
