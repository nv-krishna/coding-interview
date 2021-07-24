# Traverse Binary Tree Vertically

## Alias
- Leetcode (987): [Vertical Order Traversal of a Binary Tree](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/)

## Problem
- Traverse a binary tree vertically, group the nodes by column (y-coordinate).
- For each node at position `(row, col)`, its left and right children will be at positions `(row + 1, col - 1)` and `(row + 1, col + 1)` respectively. The root of the tree is at (0, 0).
- The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

## Examples
- Example 1
   - Binary tree

     ![vt](https://user-images.githubusercontent.com/8989447/118017769-3b449400-b314-11eb-9aab-d8ec88c1a36f.png)
   - Output: `[[4],[2],[1,5,6],[3],[7]]`
   - Explanation
      - 4 is in column -2.
      - 2 is in column -1.
      - 1,5,6 are in column 0. 
         - 1's row is 0, 1 is first
         - 5 and 6 have same row, but 5 < 6, 5 comes first.
      - 3 is in column 1
      - 7 is in column 2

## Solutions
- Solution 1: HashMap + Depth-first search
   - Use 2 HashMap to group points by y and store the relationship between points and their values.
      - HashMap 1: `yAndXsMap`
         - Goal: Group points by y.
         - Structure: TreeMap<Integer, TreeSet<Integer>>
            - Key is each unique y.
            - Value is list of multiple x.
         - Types
            - TreeMap is to sort key-value pairs by key. When we iterator each entry on TreeMap to generate the output, entry is already in y ascending order.
            - TreeSet is to sort and unify elements. 
               - Because there is no 2 points have same x and y. TreeMap already unifies at y level, so TreeSet is to unifies at x level.
               - When we iterator multiple x on TreeSet to generate the output, multiple x are already in ascending order.
      - HashMap 2: `xyAndValsMap`
         - Goal: Store the relationship between points and their values.
         - Structure: HashMap<String, PriorityQueue<Integer>>
            - Key is each unique point, use x and y join by ",".
            - Value is all the values in that point.
         - Type
            - PriorityQueue is to sort values. When a point has mulitple values (like both 5 and 6 are at point (2,0) in the example), we need to output them in asending order.

        ![vt2](https://user-images.githubusercontent.com/8989447/118025599-43ed9800-b31d-11eb-84dd-140d5e68faf0.png)
   - Process
      - Initialize 2 HashMaps.
      - Traverse the binary tree to populate those 2 HashMaps.
      - Generate the output from the 2 HashMaps.
  ```java
  class Solution {
      Map<Integer, Set<Integer>>  yAndXsMap;                      // Store the y and multiple x: Key is y, Value is x1, x2, ...
      Map<String, Queue<Integer>> xyAndValsMap;                   // Store the point and multiple vals belongs to that point: 
                                                                  // Key is "x,y", Value is val1, val2, ...
    
      public List<List<Integer>> verticalTraversal(TreeNode root) {
          this.yAndXsMap    = new TreeMap<>();
          this.xyAndValsMap = new HashMap<>();
        
          traverse(root, 0, 0);
        
          List<List<Integer>> resultList = new ArrayList<>();
        
          for (Map.Entry<Integer, Set<Integer>> entry : this.yAndXsMap.entrySet()) {
              List<Integer> columnList = new ArrayList<>();
              Integer y = entry.getKey();
              for (Integer x : entry.getValue()) {
                  String xyInString = String.valueOf(x) + "," + String.valueOf(y);
                
                  Queue<Integer> valQueue = this.xyAndValsMap.get(xyInString);
                
                  while(!valQueue.isEmpty()) {
                      columnList.add(valQueue.poll());
                  }
              }
            
              resultList.add(columnList);
          }
        
          return resultList;
      }
    
      public void traverse(TreeNode node, int x, int y) {
          if (node == null) return;
        
          if (this.yAndXsMap.get(y) == null) {
              TreeSet<Integer> xSet = new TreeSet<>();
              xSet.add(x);
              this.yAndXsMap.put(y, xSet);
          } else {
              this.yAndXsMap.get(y).add(x);
          }
        
          String xyInString = String.valueOf(x) + "," + String.valueOf(y);
          if (this.xyAndValsMap.get(xyInString) == null) {
              Queue<Integer> newQueue = new PriorityQueue<>();
              newQueue.add(node.val);
              this.xyAndValsMap.put(xyInString, newQueue);
          } else {
              this.xyAndValsMap.get(xyInString).add(node.val);
          }
        
          traverse(node.left, x+1, y-1);
          traverse(node.right, x+1, y+1);
      }
  }
  ```
  
  ![vt3](https://user-images.githubusercontent.com/8989447/118025402-0852ce00-b31d-11eb-9d45-7b4e9f1757b2.png)
