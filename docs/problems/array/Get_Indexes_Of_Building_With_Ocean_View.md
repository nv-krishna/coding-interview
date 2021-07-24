# Get Indexes of Building with Ocean View

## Alias
- Leetcode (1762): [Buildings With an Ocean View](https://leetcode.com/problems/buildings-with-an-ocean-view/)

## Problem
- Given the heights of n buildings, return the indexes of the building with ocean view.
- The ocean is to the right of the buildings. The building can have ocean view when there is no building on the right taller than or equal to the height of the building.
- The result should be sorted in ascending order.

## Solutions
- Solution 1: One pointer
   - Iterate from right to left.
   - Record the max height.
   - If the height of the current building is greater than the max height, it means that the current building has ocean view.
  ```java
  public int[] findBuildings(int[] heights) {
      List<Integer> resultList = new ArrayList<>();
        
      int maxHeight = heights[heights.length - 1];
      resultList.add(heights.length - 1);
      for (int i = heights.length - 2; i >=0; i--) {
          if (heights[i] > maxHeight) {
              resultList.add(i);
              maxHeight = heights[i];
          }
      }
        
      Collections.sort(resultList);
        
      int[] resultArray = new int[resultList.size()];
      for (int i = 0; i < resultList.size(); i++) {
          resultArray[i] = resultList.get(i);
      }
        
      return resultArray;
  }
  ```
