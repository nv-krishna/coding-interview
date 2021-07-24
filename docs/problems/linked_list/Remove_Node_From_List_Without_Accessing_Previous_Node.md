# Remove Node from List without Accessing Previous Node

## Alias
- Leetcode (237): [Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/)

## Problem
- Remove a single node.
- Cannot access the head node and the previous node.

## Solutions
- Solution 1: Swap with the next node and delete the next node.
  ```java
  public void deleteNode(ListNode node) {
      node.val = node.next.val;
      node.next = node.next.next;
  }
  ```
