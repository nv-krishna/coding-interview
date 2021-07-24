# Is Mirror Binary Trees

## Alias
- Leetcode (101): [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/) (This problem is the sub-solution of the Symmetric Tree)

## Problem
- Check 2 binary trees are mirror or not.
- Return true if 2 binary trees are mirror.

![Untitled](https://user-images.githubusercontent.com/8989447/115277555-a8904b00-a101-11eb-919a-ba79d318c736.png)

## Solutions
- Solution 1
  - For tree 1, use pre-order traverse             (root -> left -> right)
  - For tree 2, use pre-order traverse's variation (root -> right -> left)
  ```java
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
