# Get Num of Univalue Subtrees from Binary Tree

## Alias
- Leetcode (250): [Count Univalue Subtrees](https://leetcode.com/problems/count-univalue-subtrees/)

## Problem
- Get the number of uni-value subtrees from the binary tree.
- A uni-value sub-tree means all nodes of the subtree have the same value.

## Examples
- Example 1: The number of uni-value sub-trees = 4

  ![ex1](https://user-images.githubusercontent.com/8989447/115343715-94803400-a169-11eb-9f2c-a5984a6819b2.png)

- Example 2: The number of uni-value sub-trees = 4

  ![ex2](https://user-images.githubusercontent.com/8989447/115343748-9d710580-a169-11eb-84ad-039164c3bd2a.png)

- Example 3: The number of uni-value sub-trees = 2

  ![ex3](https://user-images.githubusercontent.com/8989447/115343754-a06bf600-a169-11eb-80ff-f31800a7ba30.png)


## Solutions
- Solution 1
  ```java
  public int countUnivalSubtrees(TreeNode root) {
      if (root == null) return 0;
        
      Message m = countUnivalSubtreesMessage(root);
      return m.numUniValue;
  }
      
  public Message countUnivalSubtreesMessage(TreeNode root) {
      if (root.left == null && root.right == null) {                           // has no left node and right node
          return new Message(true, 1);                                             // mark as continue and initialize the num of uni-value as 1
      }
        
      if (root.left != null && root.right != null) {                           // has both left node and right node
          Message ml = countUnivalSubtreesMessage(root.left);
          Message mr = countUnivalSubtreesMessage(root.right);
            
          if (root.left.val == root.val && root.right.val == root.val 
              && ml.isContinue && mr.isContinue) {                                 // if all 3 value are same and left and right are continue
              return new Message(true, ml.numUniValue + mr.numUniValue + 1);       // merge the nums of uni-value from left and right and then increase by 1
          } else {                                                                 // if not
              return new Message(false, ml.numUniValue + mr.numUniValue);          // just merge the nums of uni-value from left and right
          }
         
      } else if (root.left != null && root.right == null) {                    // Only has left node
          Message m = countUnivalSubtreesMessage(root.left);
            
          if (root.left.val == root.val && m.isContinue) {                         // if root's value = root's left's value and value is continue
              m.numUniValue++;                                                     // increase the num of uni-value by 1
              return m;
          } else {                                                                 // if root's value != root's left's value, or value is already non-continue
              m.isContinue = false;                                                // mark the value is not continue and just pass the num of uni-value
              return m;
          }
      } else if (root.left == null && root.right != null) {                    // Only has right node
          Message m = countUnivalSubtreesMessage(root.right);                      // similar logic 
            
          if (root.right.val == root.val && m.isContinue) {
              m.numUniValue++;
              return m;
          } else {
              m.isContinue = false;
              return m;
          }
      } else {
          return null;
      }  
  }
  
  // This class is used to pass 2 infos from bottom to up
  class Message {
      public boolean isContinue;         // is the value continue from sub-tree
      public int     numUniValue;        // number of uni-value
        
      Message (boolean isContinue, int numUniValue) {
          this.isContinue = isContinue;
          this.numUniValue = numUniValue;
      }
  }
  ```
