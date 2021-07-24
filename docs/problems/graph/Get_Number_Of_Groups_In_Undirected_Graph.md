# Get Number of Groups in Undirected Graph

## Alias
- Leetcode (547): [Number of Provinces](https://leetcode.com/problems/number-of-provinces/)
- Leetcode (323): [Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
- HackerRank: [Gifting Group]()

## Problems
- There are N nodes in the graph.
- There is a NxN 2D array to define the connection relationship between nodes.
   - The value of each cell can be 0 or 1
      - `isConnected[i][j] = 1` if the ith node and the jth node are directly connected.
      - `isConnected[i][j] = 0` if the ith node and the jth node are not directly connected.
      - `isConnected[i][j] = 1` if i == j (each node can be considered as self-connected)
- Return the total number of groups. Each group is the nodes are directedly or indirectedly connected.

## Examples
- Example 1
   - isConnected
   
     ![gp](https://user-images.githubusercontent.com/8989447/118425902-6702a980-b687-11eb-8b7d-27f608adced6.png)
   - Total number of group: 2
   - Explanation
      - `isConnected[0][1]` means the node 0 and node 1 is directly connected.
      - `isConnected[1][2]` means the node 1 and node 2 is directly connected.
      - So the node 0 and node 1 and node 2 are in one group.
      - The node 3 isn't connected with other group, so it can be considered as another group.
      - So there are 2 groups.

        ![gp2](https://user-images.githubusercontent.com/8989447/118426205-07f16480-b688-11eb-9f42-e37d54982dcf.png)

## Solutions
- Solution 1: Depth-first search
   - Create a array to record which node has been visited.
   - For each node:
      - If it is not visited by the DFS from any previous node.
      - Treat it as a new group (increase the count of group).
      - DFS from the current node.
   - DFS
      - For each next node connected with the current node:
         - If the next node is not visited:
            - Mark the next node as visited.
            - Continue the DFS from the next node.
  ```java
  public int findCircleNum(int[][] isConnected) {
      int[] visited = new int[isConnected.length];             // This array is used to record which node has been visited
      int count = 0;
      for (int i = 0; i < isConnected.length; i++) {
          if (visited[i] == 0) {                               // If the current node is not visited by DFS from any previous node
              dfs(isConnected, visited, i);                    // Depth-first search starting from the current node
              count++;                                         // Increase the count of groups
          }
      }
      return count;
  }
    
  public void dfs(int[][] isConnected, int[] visited, int i) {
      for (int j = 0; j < isConnected.length; j++) {
          if (isConnected[i][j] == 1 && visited[j] == 0) {     // If node i and node j are connected and node j is not visited 
              visited[j] = 1;                                  // visit the node j and continue the DFS from node j
              dfs(isConnected, visited, j);
          }
      }
  }
  ```
- Solution 2: Union find
   - Create a parent array
      - Each element store the index of the parent node of the current node.
      - The root node will use -1 to represent.
   - Process
      - Loop through each cell in the 2D array by row.
      - If the current cell is 1 and it is not self-connnected, union 2 nodes.
      - Union will find the root node of each node. If they have different root node (it means that they are in different groups), join 2 groups.
      - Loop through the parent array to see how many root nodes we have, it means that how many groups we have.
  ```java
  public int findCircleNum(int[][] isConnected) {
      int[] parent = new int[isConnected.length];         // Parent array store the parent node's index of each node
      Arrays.fill(parent, -1);                            // Fill all elements in parent array as -1 (each node is a single group)
      for (int i = 0; i < isConnected.length; i++) {
          for (int j = 0; j < isConnected.length; j++) {
              if (isConnected[i][j] == 1 && i != j) {     // If node i and node j are connected, union 2 nodes
                  union(parent, i, j);
              }
          }
      }
      int count = 0;
      for (int i = 0; i < parent.length; i++) {           // Count how many root nodes (it means that how many groups we have)
          if (parent[i] == -1) count++;
      }
      return count;
  }

  void union(int parent[], int x, int y) {                // Union 2 nodes
      int xset = find(parent, x);                         // Find the root node of node x
      int yset = find(parent, y);                         // Find the root node of node y
      if (xset != yset) parent[xset] = yset;              // If 2 nodes are in different groups (different root nodes), let the x node's group attach to y node's group
  }

  int find(int parent[], int i) {                         // Find the root node of the current node i
      if (parent[i] == -1) return i;                      // If the current node is -1, it means that it is a root node
      return find(parent, parent[i]);                     // Otherwise, continue search the root node
  }
  ```
  
  ![no](https://user-images.githubusercontent.com/8989447/118566728-aab1ed80-b731-11eb-9475-d1ed0f54b6ff.png)
