# Rotate List Right

## Alias
- Leetcode (61): [Rotate List](https://leetcode.com/problems/rotate-list/)

## Problem
- Right rotate a linked list in K step.
- Return the head of the rotated linked list.

## Analysis
- Right rotate a linked list K steps, is same as append the last K nodes from tail to the head.
- Need to consider K can be same or more than the size of the linked list.

![Untitled (4)](https://user-images.githubusercontent.com/8989447/115797265-c2938d00-a390-11eb-8382-8d0b3d2fb4e7.png)

## Solutions
- Solution 1
  ```java
  public ListNode rotateRight(ListNode head, int k) {
      if (head == null || head.next == null) {
          return head;
      }
        
      if (k == 0) {                                // If k = 0, nothing need to rotate 
          return head;
      }
        
      int size = getSize(head);
      int mod  = k % size;                         // mod is the actual number of steps need to rotate
        
      if (mod == 0) {                              // mod == 0 means the linked list will rotate and stop as the original linked list
          return head;
      }
        
      ListNode newTail = null;
      ListNode newHead = null;
      if (mod == size - 1) {                       // When mod = size - 1, just need to move the head as the new tail
          newTail = head;
          newHead = head.next;
      } else {
          newTail = getKthFromTail(head, mod + 1); // get the last mod number of nodes, it will be the head part
          newHead = newTail.next;                  // So the (mod + 1)th node from the original tail will be the new tail
      }                                            // So the (mod)th node from the original tail will be the new head
      ListNode oldTail = getTail(head);
        
      newTail.next = null;
      oldTail.next = head;
      return newHead;
  }
    
  // Get the size of the linked list
  public int getSize(ListNode head) {
      if (head == null) return 0;
      return getSize(head.next) + 1;
  }
  
  // Get the Kth node from tail
  public ListNode getKthFromTail(ListNode head, int k) {
      ListNode pA = head;
      ListNode pB = head;
    
      for (int i = 0; pB != null && i < k; i++) {
          pB = pB.next;
      }
    
      if (pB == null) return null;
                                                    
      while (pB != null) {
          pA = pA.next;
          pB = pB.next;
      }
    
      return pA;
  }
  
  // Get the tail node
  public ListNode getTail(ListNode head) {
      if (head.next == null) return head;
      return getTail(head.next);
  }
  ```
