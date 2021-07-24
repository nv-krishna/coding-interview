# Add Node to Sorted Circular List

## Alias
- Leetcode (708): [Insert into a Sorted Circular Linked List](https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/)

## Problem
- Add a new node into a sorted circular linked list.
- Before insertion, the sorted circular linked list is in ascending order.
- After insertion, the sorted circular linked list should keep ascending order.

## Solutions
- Solution 1: 2 neighbor pointers
   - Consider 2 cases need to add between 2 adjacent nodes
      - Case 1: Current and next node are in ascending order, and inserting value is in the range.
         - In this case, the new node will be in the middle of the ascending order.
      - Case 2: Current and next node are in descending order, and inserting value is out of the range.
         - In this case, the new node will be the end of the ascending order.
   - Consider 1 edge case: All nodes have the same value but the inserting value is different with them.
      - In this case, new node can be added between any 2 adjacent nodes.

  ![ca1](https://user-images.githubusercontent.com/8989447/117916383-4bbd2600-b2a4-11eb-9dc1-4c6e3c18b85a.png)
  
  ![ca2 (1)](https://user-images.githubusercontent.com/8989447/117916523-8e7efe00-b2a4-11eb-9dfc-393ed352711e.png)
  
  ![case3](https://user-images.githubusercontent.com/8989447/117916399-537cca80-b2a4-11eb-8dc6-d45e43c3c07e.png)

  ```java
  public Node insert(Node head, int insertVal) {
      if (head == null) {
          head = new Node (insertVal);
          head.next = head;
          return head;
      }
        
      if (head.next == head) {
          Node newNode = new Node(insertVal);
          head.next = newNode;
          newNode.next = head;
          return head;
      }
        
      Node current = head;
      boolean isVisitHead = false;      // This flag is to prevent endless looping on the circular list
      while(!isVisitHead || current != head) {
          isVisitHead = true;
            
          boolean isIncreaseGapCase = current.val < current.next.val && current.val <= insertVal && insertVal <= current.next.val;
          boolean isDecreaseGapCase = current.val > current.next.val && (insertVal >= current.val || insertVal <= current.next.val);
            
          if (isIncreaseGapCase || isDecreaseGapCase) {
              Node newNode = new Node(insertVal);
              Node currentNext = current.next;
              current.next = newNode;
              newNode.next = currentNext;
              return head;
          } 
            
          current = current.next;
      }
        
      // If all the node are same, but different with insertVal, it will add the new node between head and head.next
      Node newNode = new Node(insertVal);
      Node currentNext = current.next;
      current.next = newNode;
      newNode.next = currentNext;
      return head;
  }
  ```
