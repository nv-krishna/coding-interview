# Convert Binary Search Tree to Sorted Doubly Linked List

## Alias
- Leetcode (426): [Convert Binary Search Tree to Sorted Doubly Linked List](https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/)

## Problem
- Convert a binary search tree to a sorted circular doubly-linked list in place.
- For each node
   - Left pointer points to the predecessor in the linked list
   - Right pointer points to the successor in the linked list
- For double linked list 
   - The predecessor of the first element is the last element.
   - The successor of the last element is the first element.
   - Return the first element.

## Examples
- Example 1

  ![dds2](https://user-images.githubusercontent.com/8989447/119085662-62106380-b9c1-11eb-8f7f-1ac69e26009e.png)

## Solutions
- Solution 1: In-order traversal
   - Use In-order traversal to relink each node
   - Use 2 global pointers to track the first node and the last visited node.
   - In-order traversal
      - If the last visited node is null, set the current node as the first node
      - If the last visited node is not null, set the last visited node's right to the current node, set the current node's left to the last visited node.
   - After finishing in-order traversal, link between the first node and the last node in the double linked list.

     ![dds2](https://user-images.githubusercontent.com/8989447/119085709-70f71600-b9c1-11eb-9cfb-fc6ee7cb9926.png)

  ```java
  class Solution {
      Node first = null;                        // The first (smallest) node
      Node last  = null;                        // The last visited node
    
      public Node treeToDoublyList(Node root) {
          if (root == null) return null;
        
          inorder(root);
        
          last.right = first;                   // Close the doubled linked list
          first.left = last;
        
          return first;
      }
    
      public void inorder(Node node) {
          if (node == null) return;
          inorder(node.left);
        
          if (last != null) {
              last.right = node;                // Link the last visit node's right to the current node
              node.left = last;                 // Link the current node's left to the last visit node
          } else {
              first = node;                     // If the last node is null, it means that the current node is leftmode node, 
          }                                     // so save the current node as the first node
          last = node;                          // Save the last visited node

          inorder(node.right);
      }
  }
  ```
