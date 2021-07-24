# Merge 2 Sorted Arrays

## Alias
- Leetcode (88): [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)

## Problem
- Merge the 2nd array into the 1st array and keep element sorted.

## Solution
- Solution 1: Merge and sort
  ```
  public void merge(int[] nums1, int m, int[] nums2, int n) {
      for (int i = 0; i < n; i++) {
          nums1[i + m] = nums2[i];
      }
      Arrays.sort(nums1);
  }
  ```
- Solution 2: 3 pointers
   - Copy the 1st array into another array so that the 1st array can be overwritten by the merged results.
   - Use 2 pointers for comparing the next elements in the 1st array and the 2nd array and use another pointer to locate the next position to be populated.
  ```java
  public void merge(int[] nums1, int m, int[] nums2, int n) {
      // Copy the nums1 into another array so that nums1 can be overwritten by the merged results
      int[] nums1Copy = new int[m];
      for (int i = 0; i < m; i++) {
          nums1Copy[i] = nums1[i];
      }
        
      int p1 = 0;
      int p2 = 0;
        
      for (int i = 0; i < m + n; i++) {
          if (p1 < m && p2 < n) {
              if (nums1Copy[p1] <= nums2[p2]) {
                  nums1[i] = nums1Copy[p1];
                  p1++;
              } else {
                  nums1[i] = nums2[p2];
                  p2++;
              }
          } else if (p2 < n) {
              nums1[i] = nums2[p2];
              p2++;
          } else if (p1 < m) {
              nums1[i] = nums1Copy[p1];
              p1++;
          }
      }
  }
  ```
   
