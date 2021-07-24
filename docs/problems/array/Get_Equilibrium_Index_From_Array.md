# Get Equilibrium Index from Array

## Alias
- Leetcode (724): [Find Pivot Index](https://leetcode.com/problems/find-pivot-index/)

## Problem
- Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
- Return the equilibrium index of the input array.

## Examples
- Example 1
   - Input array: `[5, 500, 2 ,3]`
   - Equilibrium index: `1`
   - Explanation: 5 = 2 + 3
- Example 2
   - Input array: `[-7, 1, 5, 2, -4, 3, 0]`
   - Equilibrium index: `3`
   - Explanation; -7 + 1 + 5 = -4 + 3 + 0

## Solution
- Solution 1: Prefix sum array.
  ```java
  public int pivotIndex(int[] nums) {
      if (nums == null) {
          return -1;
      }
        
      if (nums.length == 0) {
          return -1;
      }
        
      if (nums.length == 1) {
          return nums[0];
      }
        
      int[] prefixSumArray = new int[nums.length];
      prefixSumArray[0] = nums[0];
      for (int i = 1; i < nums.length; i++) {
          prefixSumArray[i] = prefixSumArray[i-1] + nums[i];
      }
        
      // the index 0 is the equilibrium index
      if (prefixSumArray[nums.length - 1] - prefixSumArray[0] == 0) {
          return 0;
      }
        
      for (int i = 1; i < nums.length - 1; i++) {
          int leftSum  = prefixSumArray[i-1];
          int rightSum = prefixSumArray[nums.length - 1] - prefixSumArray[i];
            
          if (leftSum == rightSum) {
              return i;
          }
      }
        
      // the index (nums.length - 1) is the equilibrium index
      if (prefixSumArray[nums.length - 2] == 0) {
          return nums.length - 1;
      }
        
      return -1;
  }
  ```
