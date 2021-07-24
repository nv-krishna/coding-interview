# Get Random Node from List

## Alias
- Leetcode (382): [Linked List Random Node](https://leetcode.com/problems/linked-list-random-node/)

## Problem
- Return a random node's value from the linked list.
- Each node must have the same probability of being chosen.

## Solutions
- Solution 1: Reservoir sampling
   - Treat each node as candidate.
   - Even if 2 nodes have same value, treat them as different candidates.
   - At each time when we find a new candidate, we have to make the decision of whether or not to choose this candidate.
   - The overall probability of each candidate being chosen is same (1 / Total number of candicates).
  ```java
  class Solution {
      private ListNode head;
      private Random rand;

      public Solution(ListNode head) {
          this.head = head;
          this.rand = new Random();
      }
    
      /** Returns a random node's value. */
      public int getRandom() {
          int count = 0;                         // Count the number of candicates
          int value = 0;                         // The value to return
        
          ListNode current = head;
          while (current != null) {
              count++;
              if (rand.nextInt(count) == 0) {    // We pick the current number with probability 1 / count (reservoir sampling)
                  value = current.val;
              }
              current = current.next;
          }
        
          return value;
      }
  }
  ```
