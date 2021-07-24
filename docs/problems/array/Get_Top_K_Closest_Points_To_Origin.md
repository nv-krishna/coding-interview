# Get Top K Closest Points to Origin

## Alias
- Leetcode (973): [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)

## Problem
- Give an array of points, get top K closest points to origin (0,0).
- Distance can be calculated by (x<sub>1</sub> - x<sub>2</sub>)<sup>2</sup> + (y<sub>1</sub> - y<sub>2</sub>)<sup>2</sup>

## Solution
- Solution 1: Custom class + Sort list
  ```java
  class Solution {
      public int[][] kClosest(int[][] points, int k) {
          List<Point> pointList = new ArrayList<>();
        
          for (int i = 0; i < points.length; i++) {
              pointList.add(new Point(points[i][0], points[i][1]));
          }
        
          Collections.sort(pointList);
        
          int size = k > pointList.size()? pointList.size() : k;
          int[][] result = new int[size][2];
        
          for (int i = 0; i < size; i++) {
              result[i][0] = pointList.get(i).x;
              result[i][1] = pointList.get(i).y;
          }
        
          return result;
      }
  }

  public class Point implements Comparable<Point> {
      public int x;
      public int y;
      public Double distance;
    
      public Point(int x, int y) {
          this.x = x;
          this.y = y;
          this.distance = calculateDistance(x, y);
      }
        
      public Double calculateDistance(int x, int y) {
          return Math.sqrt(x*x + y*y);
      }
    
      public int compareTo(Point p) {
          return this.distance.compareTo(p.distance);
      }
  }
  ```
