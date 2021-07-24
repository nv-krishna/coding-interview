# Remove Nodes from List by Value

## Alias
- Leetcode (203): [Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/)

## Problem
- Remove all the nodes whose value is equal to a specific value.
- Return the head of the new linked list.

## Solutions
- Solution 1: 
  ```java
  public ListNode deleteNodesByValue(ListNode head, int val) {        
      while (head != null && head.val == val) {            // Consider the value of the head is equal to the target value.
          head = head.next;
      }
        
      if (head == null) {
          return null;
      }
        
      ListNode current = head;
        
      while (current.next != null) {
          if (current.next.val == val) {
              current.next = current.next.next;
          } else {
              current = current.next;
          }
      }
        
      return head;
  }
  ```
