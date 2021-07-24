# Implement Binary Search Tree Iterator

## Alias
- Leetcode (173): [Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/)

## Problem
- Implement a binary search tree iterator class with following functions.
   - `BSTIterator(TreeNode root)`: Initializes an object of the BSTIterator class.
   - `int next()`: Returns the value of the next node in the in-order traversal.
   - `boolean hasNext()`: Returns true if there is a next node in the in-order traversal, and false otherwise.

## Solutions
- Solution 1: List + In-order traversal.
   - Use in-order traveral to add the value of each node into a list.
   - Use an index to remember the current postion.
   - `next()` will get the value of the current postion and move to the next one in the list.
   - `hasNext()` will check the index has reached to the end of the list or not.
  ```java
  class BSTIterator {
      public List<Integer> list; 
      public int index;
    
      public BSTIterator(TreeNode root) {
          this.list = new ArrayList<>();
          this.index = 0;
          traverseInOrder(root);
      }
    
      public int next() {
          if (index >= list.size()) {
              return -1;
          }
          int val = this.list.get(this.index);
          index++;
          return val;
      }
    
      public boolean hasNext() {
          return index < list.size();
      }
    
      public void traverseInOrder(TreeNode node) {
          if (node == null) return;
          traverseInOrder(node.left);
          this.list.add(node.val);
          traverseInOrder(node.right);
      }
  }
  ```
