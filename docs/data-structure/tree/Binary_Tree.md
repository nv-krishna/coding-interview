# Binary Tree

- [**Concept**](#concept)
   - [Rules](#rules)
   - [Code](#code)
   - [Types](#types)
   - [Variations](#variations)
- [**Basic operations**](#basic-operations)
   - [Traverse](#traverse)
      - [Depth-first search (DFS)](#depth-first-search-dfs)
      - [Breadth-first search (BFS)](#breadth-first-search-bfs)
- [**Strategies**](#strategies)
- [**Common Topics**](#common-topics)

## Concept
### Rules
- Each node has at most two children, which are referred to as the left child and the right child.

### Code
```
TreeNode {
    int      data;
    TreeNode left;
    TreeNode right;
}
```

### Types
- **Full binary tree**: 
   - Every node has either 0 or 2 children.

     <img src="https://user-images.githubusercontent.com/8989447/115163571-0d4a9780-a067-11eb-8615-873f5aa8fdb9.png" width="320" height="239">

- **Complete binary tree**: 
   - Every level, except the last, is completely filled.
   - All nodes in the last level are as far left as possible

     <img src="https://user-images.githubusercontent.com/8989447/115163595-26ebdf00-a067-11eb-93a6-a54c8dd83bf2.png" width="480" height="250">

- **Balanced binary tree**
   - The left and right subtrees of every node differ in height by no more than 1.
   - All operations on abalanced tree can be guarantee that runs at O(*lg*n).
- **Perfect binary tree**
   - All interior nodes have two children.
   - All leaves have the same depth or same level.

### Variations
- **Binary search tree (BST)**
   - Binary tree.
   - For each internal nodes, the key greater than all the keys in the node's left subtree and less than those in its right subtree.
- **Binary heap**
   - Complete binary tree.
   - The key stored in each node is either greater than or equal to (≥) or less than or equal to (≤) the keys in the node's children.

## Basic operations
### Traverse
#### Depth-first search (DFS)
- **Pre-order**
   - Order: Root, left, right.
   - Features:
      - This traverse can be used in top-down approach.
  ```
  void traversePreOrder(TreeNode node) {
      if (node == null) return;
      visit(node);
      traversePreOrder(node.left);
      traversePreOrder(node.right);
  }
  ```
- **In-order**
   - Order: Left, root, right.
   - Features:
      - In a binary search tree, in-order traversal retrieves the keys in ascending sorted order.
  ```
  void traverseInOrder(TreeNode node) {
      if (node == null) return;
      traverseInOrder(node.left);
      visit(node);
      traverseInOrder(node.right);
  }
  ```
- **Reverse in-order**
   - Order: Right, root, left.
   - Features:
      - In a binary search tree, reverse in-order traversal retrieves the keys in descending sorted order.
  ```
  void traverseReverseInOrder(TreeNode node) {
      if (node == null) return;
      traverseReverseInOrder(node.right);
      visit(node);
      traverseReverseInOrder(node.left);
  }
  ```
- **Post-order**
   - Order: Left, right, root.
   - Features:
      - This traverse can be used in bottom-up approach.
  ```
  void traversePostOrder(TreeNode node) {
      if (node == null) return;
      traversePostOrder(node.left);
      traversePostOrder(node.right);
      visit(node);
  }
  ```
- **Pre-order (iterative solution)**
  ```
  void traversePreOrder(TreeNode root) {
      Stack stack;
      stack.push(root);
      while (stack.isEmpty() == false) {
          TreeNode node = stack.pop();
          visit(node);
          if (node.left != null) { 
              stack.push(node.left);
          }
          if (node.right != null) {
              stack.push(node.right);
          }
      }
  }
  ```
  
#### Breadth-first search (BFS)
  ```
  void traverseBreadthFirstSearch(TreeNode root) {
      Queue queue;
      queue.enqueue(root);
      while(queue.isEmpty() == false) {
          TreeNode node = queue.dequeue();
          visit(node);
          if (node.left != null) { 
              queue.enqueue(node.left);
          }
          if (node.right != null) {
              queue.enqueue(node.right);
          }
      }
  }
  ```
  ![Screen Shot 2021-04-20 at 11 36 26 PM](https://user-images.githubusercontent.com/8989447/115501908-4a628580-a231-11eb-8042-a151014242bf.png)

## Strategies
- Consider using a recursive function for most binary tree problems.

## Common Topics
- Check characteristics
   - Check one tree
      - [Is Symmetric Binary Tree](../../../docs/problems/tree/Is_Symmetric_Binary_Tree.md)
      - [Is Binary Search Tree](../../../docs/problems/tree/Is_Binary_Search_Tree.md)
   - Compare two trees
      - [Is Same Binary Trees](../../../docs/problems/tree/Is_Same_Binary_Trees.md)
      - [Is Mirror Binary Trees](../../../docs/problems/tree/Is_Mirror_Binary_Trees.md)
      - [Is Sub Binary Trees](../../../docs/problems/tree/Is_Sub_Binary_Trees.md)
- Manipulation
   - [Invert Binary Tree](../../../docs/problems/tree/Invert_Binary_Tree.md)
- Path
   - [Get Longest Path Length from Binary Tree](../../../docs/problems/tree/Get_Longest_Path_Length_From_Binary_Tree.md)
   - [Get Maximum Path Sum from Binary Tree](../../../docs/problems/tree/Get_Maximum_Path_Sum_From_Binary_Tree.md)
   - [Get Sums of All Root-to-leaf Paths from Binary Tree](../../../docs/problems/tree/Get_Sums_Of_All_Root_To_Leaf_Paths_From_Binary_Tree.md)
- Get metrics
   - [Get Height from Binary Tree](../../../docs/problems/tree/Get_Height_From_Binary_Tree.md)

## References
- https://en.wikipedia.org/wiki/Binary_search_tree
- https://en.wikipedia.org/wiki/Binary_heap
- https://en.wikipedia.org/wiki/Tree_traversal
