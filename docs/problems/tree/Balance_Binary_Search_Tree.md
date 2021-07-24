# Balance Binary Search Tree

## Alias
- Leetcode (1382): [Balance a Binary Search Tree](https://leetcode.com/problems/balance-a-binary-search-tree/)

## Problem
- Balance a binary search tree and return the new root of the balanced binary search tree.
- A binary tree is balanced if the left and right subtrees of every node differ in height by no more than 1.
- If there is more than one answer, return any of them.

## Examples
- Example 1

  ![bstb](https://user-images.githubusercontent.com/8989447/118379024-d3e94700-b594-11eb-9c08-948cbc0660f4.png)

## Solutions
- Solution 1
   - In-order traverse the binary search tree and add each visited node into a list.
      - In a binary search tree, in-order traversal retrieves the values in ascending sorted order. So we don't have to sort the list after the traversal.
   - Build the balanced binary search tree from the list
      - Each time, pick the middle one from the range as the value of the current node.
  ```java
  class Solution {
      List<Integer> valueList;
    
      public TreeNode balanceBST(TreeNode root) {
          this.valueList = new ArrayList<>();
          traverse(root);
          TreeNode newRoot = buildBST(valueList, 0, this.valueList.size() - 1);
          return newRoot;
      }
    
      public void traverse(TreeNode node) {
          if (node == null) return;
          traverse(node.left);
          this.valueList.add(node.val);            // In BST, in-order traversal retrieves the values in ascending sorted order.
          traverse(node.right);
      }
    
      public TreeNode buildBST(List<Integer> valueList, int left, int right) {
          if (left > right) {
              return null;
          }
  
          int middle = (left + right) / 2;
          TreeNode node = new TreeNode(valueList.get(middle));
  
          node.left  = buildBST(valueList, left, middle - 1);
          node.right = buildBST(valueList, middle + 1, right);
          
          return node;
      }
  }
  ```
