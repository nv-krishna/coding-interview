# Union Find

- [**Alias**](#alias)
- [**Concepts**](#concepts)
- [**Algorithm**](#algorithm)
   - [Basics](#basics)
   - [Initialization](#initialization)
   - [Find](#find)
   - [Union](#union)
- [**Time complexity**](#time-complexity)
- [**Problems can use this pattern**](#problems-can-use-this-pattern)
- [**trategies**](#strategies)
- [**References**](#references)

## Alias
- Disjoint set
- Merge find

## Concepts
- A data structure that keeps track of elements which are split into one or more non-overlapping groups.

## Algorithm
### Basics
- Graph
   - Each group will have one or more nodes.
   - Each group will have a root node.
   - If a group has multiple nodes, each node except the root node will have parent node.
- There are 2 operation in this algorithm:
   - Find: Get the root node of the input node.
   - Union: Merge the 2 input nodes' groups.
- Tracking group information
   - Use 1D array or HashMap to track nodes' relationship.
   - The key is the node ID (index can be the key if using array).
   - The value is the parent node ID of the current node.

### Initialization
- Idea
   - Treat each node as a single group.
- Process
   - Create a N size array or HashMap.
      - The value of each element is to track the parent node of the current node.
   - Assign each node's parent node ID: 
      - Option 1: Use -1 (-1 means root node).
      - Option 2: Use its own node ID (each node's parent is itself).

        ![Union_Find_1](https://user-images.githubusercontent.com/8989447/118570540-9d98fc80-b739-11eb-9848-eac0b5207af5.png)
- Code
  ```
  void initialize (int size) {
      int[] parent = new int[size];
      
      for (int i = 0; i < size; i++) {
          parent[i] = -1;              // Assign each node's parent as -1 (each node is a single group)
      }
  }
  ```

### Find
- Idea
   - Find the root node ID of the input node.
- Process
   - If the parent node of the current node is -1, it means that the current node is a root node, so return it.
   - If not, continue search on 
- Code
  ```
  int find(int parent[], int i) {
      if (parent[i] == -1) return i;             // If the parent node of the current node is -1, it means that the current node is a root node, so return
      return find(parent, parent[i]);            // If not, continue searching on the parent node
  }
  ```
- Examples
   - Find(0) = 2 (Find the root node of the node 0)
   - Find(2) = 2 (Find the root node of the node 2)
     
     ![Untitled (5)](https://user-images.githubusercontent.com/8989447/119250092-eea25980-bb5a-11eb-85f3-40d1a78e19cd.png)

### Union
- Idea
   - Merge the 2 input nodes' groups.
- Process
   - Find the root node of the first node.
   - Find the root node of the second node.
   - If 2 root nodes are different (it means that those 2 nodes are in different groups), merge 2 groups by changing the parent node of one root node as another root node.
- Code
  ```
  void union(int parent[], int i, int j) {
      int iRoot = find(parent, i);               // Find the root node of node i
      int jRoot = find(parent, j);               // Find the root node of node j
      if (iRoot != jRoot) parent[iRoot] = jRoot; // If 2 root nodes are different (it means that node i and node j are in different groups), merge them
  }
  ```
- Examples
   - Union(0,4) (Merge the group has the node 0 with the group has the node 4)
   
     ![uf](https://user-images.githubusercontent.com/8989447/119250427-48a41e80-bb5d-11eb-8762-a93de17d88c1.png)

## Time complexity
- Find: O(a(n))
- Union: O(a(n))

(a(n) is inverse Ackermann function, it grows extremely slow)

## Problems can use this pattern
- Grouping
   - [Get Number of Groups in Undirected Graph](../../docs/problems/graph/Get_Number_Of_Groups_In_Undirected_Graph.md)
   - [Accounts Merge](../../docs/problems/other/Accounts_Merge.md)
- Detecting Cycle
   - [Detect Cycle in Undirected Graph](../../docs/problems/graph/Detect_Cycle_In_Undirected_Graph.md)

## Strategies
- For the problems can be solved by Union find, they often can be solved by Depth-first search. But Union find solution can provide a better performance.

## References
- https://en.wikipedia.org/wiki/Disjoint-set_data_structure#Proof_of_O(log*(n))_time_complexity_of_Union-Find
- https://www.geeksforgeeks.org/union-find/
