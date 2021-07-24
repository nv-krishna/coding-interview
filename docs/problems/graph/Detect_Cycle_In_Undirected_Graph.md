# Detect Cycle in Undirected Graph

## Alias
- GeeksforGeeks: [Detect Cycle in an Undirected Graph](https://www.geeksforgeeks.org/union-find/)

## Problem
- Given an array of edges.
- Each edge is represented as an array of 2 elements
   - The first element is the starting node ID.
   - The second element is the ending node ID.
- Check the graph has a cycle or not.

## Examples
- Example 1
   - Edges:`[[0, 1], [1, 2], [2, 3], [4, 5]]`
   - Has cycle: false
   - Explanation: 

     ![cy](https://user-images.githubusercontent.com/8989447/118594114-1c0b9380-b766-11eb-97a8-eed6d42960ae.png)

- Example 2
   - Edges:`[[0, 1], [1, 2], [2, 0], [3, 4]]`
   - Has cycle: true
   - Explanation: 
   
     ![cy2](https://user-images.githubusercontent.com/8989447/118594610-f632be80-b766-11eb-83b0-90390f2da3cf.png)

## Solutions
- Solution 1: Union find
  ```java
  public boolean detectCycle(int[][] edges, int numOfNodes) {
       int[] parent = new int[numOfNodes];
       Arrays.fill(parent, -1);
       for (int i = 0; i < edges.length; i++) {
           if (union(parent, edges[i][0], edges[i][1])) {
               return true;
           }
       }
       return false;
  }
	
  int find(int parent[], int i) {
      if (parent[i] == -1) return i;
      return find(parent, parent[i]);
  }

  boolean union(int parent[], int i, int j) {
      int iRoot = find(parent, i);
      int jRoot = find(parent, j);
      if (iRoot != jRoot) { 
          parent[iRoot] = jRoot;
          return false;
      } else { 
          return true;                 // If node i and node j already have same root (node i already has a path to node j), 
      }                                // it means that this new edge i-j will make a cycle
  }
  ```
