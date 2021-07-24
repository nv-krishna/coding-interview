# Linked List

- [**Concept**](#concept)
- [**Basic operations**](#basic-operations)
   - [Traverse](#traverse)
      - [Traverse in order](#traverse-in-order)
      - [Traverse in reversed order](#traverse-in-reversed-order)
   - [Access](#access)
      - [Access the first node](#access-the-first-node)
      - [Access the last node](#access-the-last-node)
      - [Access the Kth node](#access-the-kth-node)
      - [Access the Kth node from tail](#access-the-kth-node-from-tail)
   - [Manipulation](#manipulation)
      - [Add](#add)
         - [Add a node at the head](#add-a-node-at-the-head)
         - [Add a node at the tail](#add-a-node-at-the-tail)
         - [Add a node at the Kth](#add-a-node-at-the-kth)
      - [Remove](#remove)
         - [Remove the head node](#remove-the-head-node)
         - [Remove the tail node](#remove-the-tail-node)
         - [Remove the Kth node](#remove-the-kth-node)
- [**Strategies**](#strategies)
- [**Common Topics**](#common-topics)

## Concept
### Code
```
ListNode {
    int      data;
    ListNode next;
}
```

## Basic operations
### Traverse
#### Traverse in order
```
void traverse(ListNode head) {
    ListNode current = head;
    while (current != null) {
        visit(head);
        current = current.next;
    }
}
```

#### Traverse in reversed order
```
void traverseReversedOrder(ListNode head) {
    if (head == null) return;
    traverseReversedOrder(head.next);
    visit(head);
}
```

### Access
#### Access the first node
```
ListNode getFirst(ListNode head) {
    return head;
}
```

#### Access the last node
```
ListNode getLast(ListNode head) {
    ListNode current = head;
    while (current.next != null) {
        current = current.next;
    }
    return current;
}
```

#### Access the Kth node
```
ListNode getKth(ListNode head, int k) {
    ListNode current = head;
    int i = 0;
    
    while (current.next != null && i < k) {
        current = current.next;
        i++
    }
    
    if (k == i) {
        return current;
    } else {                                       // If the K is greater than the total number of nodes
        return null;                               // Returning null means there is no Kth node
    }
}
```

#### Access the Kth node from tail
- **Solution 1**: Use recursive function.
  ```
  int getKthFromTail(ListNode head, int k) {                 // Return value is the Ith node from tail
      if (head == null) return 0;
      int count = getKthFromEnd(node.next, k) + 1;
    
      if (i == k) {
          // current is the Kth from tail
      }
    
      return count;
  }
  ```
- **Solution 2**: Use 2 pointers.
   - Let pA point to the head, let pB point to the Kth node from the head.
   - Move pA and pB to the tail in the same pace so the distance between pA and pB is always K.
   - When pB points to the tail, pA is pointing to the Kth node from the tail.
  ```
  ListNode getKthFromTail(ListNode head, int k) {
      ListNode pA = head;
      ListNode pB = head;
      
      for (int i = 0; pB != null && i < k; i++) {     // Let pB point to the Kth node from the head.
          pB = pB.next;
      }
      
      if (pB == null) return null;                    // If the K is greater than the total number of nodes, return null
                                                      // Returning null means there is no Kth node from the tail
                                                      
      while (pB != null) {                            // Move pA and pB to the tail in the same pace until pB points to the tail
          pA = pA.next;
          pB = pB.next;
      }
      
      return pA;
  }
  ```
- **Solution 3**: Get the (N-K+1)th node from the head.

### Manipulation
#### Add
##### Add a node at the head
```
ListNode addNodeAtHead(ListNode head, ListNode node) {
    node.next = head;
    return node;                                       // Return the new head node
}
```
##### Add a node at the tail
```
void addNodeAtTail(ListNode head, ListNode node) {    
    ListNode current = head;
    while (current.next != null) {                     // Get the original tail node
        current = current.next;
    }
    
    current.next = node;
}
```
##### Add a node at the Kth
```
void addNodeAtKth(ListNode head, ListNode node, int k) {
    ListNode current = head;
    int i = 0
    
    while (current.next != null && i < k - 1) {        // Get the K-1 th node
        current = current.next;
        i++
    }
    
    if (i == k - 1) {
        node.next = current.next;
        current.next = node;
    } else {                                           // If there is no K-1 th node, do nothing
        return;
    }
}
```

#### Remove
##### Remove the head node
```
ListNode removeNodeAtHead(ListNode head) {
    ListNode newHead = head.next;
    return newHead;
}
```
##### Remove the tail node
```
void removeNodeAtTail(ListNode head) {
    if (head.next == null) {                          // If there is only one node in the linked list
        free(head);                                   
        return null;
    }

    ListNode current = head;
    while (current.next.next == null) {               // Get the preceding node of the tail node
        current = current.next;
    }
    
    current.next = null;
}
```
##### Remove the Kth node
```
void removeKthNode(ListNode head, int k) {
    ListNode current = head;
    int i = 0
    
    while (current.next != null && i < k - 1) {        // Get the K-1 th node
        current = current.next;
        i++
    }
    
    if (i == k - 1) {
        if (current.next == null) {                    // If there is the K-1 th node, but no Kth node, do nothing.
            return;
        } else {
            current.next = current.next.next;          // If there are both the K-1 th and the Kth node, remove the Kth node.
        }
    } else {                                           // If there is no K-1 th node, do nothing
        return;
    }
}
```

## Strategies
- If an operation is against the direction of a linked list, consider using a recursive function.
- If an operation is to manipulate (add or remove) a certain node, consider getting the previous node of the target node.

## Common Topics
- Check characteristics
   - Check one list
      - [Is Palindrome List](../../../docs/problems/linked_list/Is_Palindrome_List.md)
   - Compare two lists
- Manipulation
   - Reverse
      - [Reverse List](../../../docs/problems/linked_list/Reverse_List.md)
      - [Reverse Sub-list](../../../docs/problems/linked_list/Reverse_Sub_List.md)
   - Remove
      - [Remove Duplicates from List](../../../docs/problems/linked_list/Remove_Duplicates_From_List.md)
      - [Remove Duplicates from Sorted List](../../../docs/problems/linked_list/Remove_Duplicates_From_Sorted_List.md)
      - [Remove Node without Accessing Previous Node](../../../docs/problems/linked_list/Remove_Node_From_List_Without_Accessing_Previous_Node.md)
      - [Remove Nodes by Value](../../../docs/problems/linked_list/Remove_Nodes_From_List_By_Value.md)

## References
- https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
