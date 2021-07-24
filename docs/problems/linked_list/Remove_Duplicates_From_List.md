# Remove Duplicates from List

## Problem
- Remove all duplicates from a unsorted list.
- Return the head of the new linked list.

## Solutions
- Solution 1: 2 pointers
  ```java
  public void deleteDuplicates(ListNode head) {
      ListNode current = head;
      
      while (current != null) {
          ListNode runner = current;

          while (runner.next != null) {
              if (runner.next.data == current.data) {
                  runner.next = runner.next.next;
              } else {
                  runner = runner.next;
              }
          }

          current = current.next;
      }
      
      return head;
  }
  ```
