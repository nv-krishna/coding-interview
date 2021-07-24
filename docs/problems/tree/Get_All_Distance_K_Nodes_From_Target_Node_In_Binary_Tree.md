# Get All Distance K Nodes from Target Node in Binary Tree

## Alias
- Leetcode (863): [All Nodes Distance K in Binary Tree](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/)

## Problem
- Given a binary tree, return a list of the values of all nodes that have a distance k from the target node.

## Examples
- Example 1
   - Binary tree:
     
     ![dis](https://user-images.githubusercontent.com/8989447/119074934-2a97bc00-b9ad-11eb-9c16-e7195ba00413.png)

   - Target Node: 5
   - K: 2
   - Output: `[7,4,1]`

## Solutions
- Solution 1 Depth-first search
   - Distance K nodes can happen in the following cases
      - Child nodes (Target=5, K=2)
        
        ![child](https://user-images.githubusercontent.com/8989447/119075223-adb91200-b9ad-11eb-85ef-6c5ce587db7f.png)
      - Parent node (Target=5, K=2)

        ![parent (1)](https://user-images.githubusercontent.com/8989447/119075666-5ebfac80-b9ae-11eb-9195-89c83f672bf0.png)
      - Nodes in another branch (Target=5, K=3)

        ![branch](https://user-images.githubusercontent.com/8989447/119075847-ba8a3580-b9ae-11eb-9c54-5941e523a89e.png)
  ```java
  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
      if (K == 0) {
          return Arrays.asList(target.val);
      }
        
      List<Integer> resultList = new ArrayList<>();
      findChildNodesDistanceK(target, resultList, K);             // Get all the K distance child nodes of the target node
      resultList.addAll(distanceKRecurse(root, target, K));       // Get the K distance parent node and the nodes in another branch
        
      return resultList;
  }
    
  public List<Integer> distanceKRecurse(TreeNode root, TreeNode target, int K) {
      List<Integer> resultList = new ArrayList<>();
        
      int leftDis  = findTargetNodesDistance(root.left, target);
      int rightDis = findTargetNodesDistance(root.right, target);
        
      if (leftDis != -1) {
          if (leftDis > K) {
              // find (leftDis - K) distance node from root on left branch
              findChildNodesDistanceKWithTarget(root.left, target, resultList, K, (leftDis-K-1));
          } else if (leftDis < K) {
              // find (K - leftDis) distance node from root on right branch
              findChildNodesDistanceK(root.right, resultList, (K-leftDis-1));
              resultList.addAll(distanceKRecurse(root.left, target, K));
          } else {
              resultList.add(root.val);
              resultList.addAll(distanceKRecurse(root.left, target, K));
          }
      }
        
      if (rightDis != -1) {
          if (rightDis > K) {
              // find (rightDis - K) distance node from root on right branch
              findChildNodesDistanceKWithTarget(root.right, target, resultList, K, (rightDis-K-1));
          } else if (rightDis < K) {
              // find (K - rightDis) distance node from root on left branch
              findChildNodesDistanceK(root.left, resultList, (K-rightDis-1));
              resultList.addAll(distanceKRecurse(root.right, target, K));
          } else {
              resultList.add(root.val);
              resultList.addAll(distanceKRecurse(root.right, target, K));
          }
      }
        
      return resultList;
  }
    
  // Get the K distance child node from the current node
  public void findChildNodesDistanceK(TreeNode node, List<Integer> resultList, int K) {
      if (node == null) return;
      if (K == 0) resultList.add(node.val);
      findChildNodesDistanceK(node.left, resultList, K-1);
      findChildNodesDistanceK(node.right, resultList, K-1);
  }
    
  // Calculate the distance from the current node to the target node
  // Return -1 if any child nodes don't have the target node
  public int findTargetNodesDistance(TreeNode node, TreeNode target) {
      if (node == null) return -1;
      if (node.val == target.val) return 1;
        
      int leftDis  = findTargetNodesDistance(node.left, target);
      int rightDis = findTargetNodesDistance(node.right, target);
        
      if (leftDis == -1 && rightDis == -1) {
          return -1;
      } else if (rightDis != -1) {
          return rightDis + 1;
      } else {
          return leftDis + 1;
      }
  }
    
  // Find the child node of the current node which is the K distance parent node and the nodes in another branch
  public void findChildNodesDistanceKWithTarget(TreeNode node, TreeNode target, List<Integer> resultList, int K, int depth) {
      if (node == null) return;
        
      int leftDis  = findTargetNodesDistance(node.left, target);
      int rightDis = findTargetNodesDistance(node.right, target);
        
      if (depth == 0 && (leftDis != -1 || rightDis != -1)) resultList.add(node.val);    // Add the K distance parent node to the result list
        
      if (leftDis != -1) {                                                              // If the left branch has the target node
          findChildNodesDistanceKWithTarget(node.left, target, resultList, K, depth-1); // Recurse on the left branch
          if (depth < 0) {
              findChildNodesDistanceK(node.right, resultList, K-leftDis-1);             // Consider the K distance nodes in another branch
          }
      }
      if (rightDis != -1) {                                                             // If the right branch has the target node
          findChildNodesDistanceKWithTarget(node.right, target, resultList, K, depth-1);// Recurse on the right branch
          if (depth < 0) {
              findChildNodesDistanceK(node.left, resultList, K-rightDis-1);             // Consider the K distance nodes in another branch
          }
      }
  }
  ```
