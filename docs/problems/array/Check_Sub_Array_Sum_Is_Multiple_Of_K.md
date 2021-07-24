# Check Sub-array Sum Is Multiple of K

## Alias
- Leetcode (523): [Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/)

## Problem
- Check the input array has a sub-array whose sum is equal to K or is a multiple of K.
- The size of a sub-array must be at least two.
- Return true if there is a sub-array match the criteria.

## Solution
- Solution 1: Prefix sum array + 2 brute force pointers.
   - Calculate the prefix sum array of the input array.
   - Check each element of prefix sum array can match the criteria or not (Check the sum of [0,i] can match or not).
   - Check any middle sub-array can match the criteria or not (Check the sum of [i, i + distance] can match or not).
      - The i is the base-index
      - The distance is the sliding window's length
  ```java
  public boolean checkSubarraySum(int[] nums, int k) {
      if (nums == null) {
          return false;
      }
        
      if (nums.length == 1) {
          return false;
      }
            
      int[] prefixSumArray = new int[nums.length];
      prefixSumArray[0] = nums[0];
        
      for(int i = 1; i < nums.length; i++) {
          prefixSumArray[i] = prefixSumArray[i-1] + nums[i];
          if (prefixSumArray[i] == k || prefixSumArray[i] % k == 0) {
              return true;
          }
      }
        
      for (int distance = 2; distance < nums.length; distance++) {
          for (int i = 0; i + distance < nums.length; i++) {
              int sum = prefixSumArray[i + distance] - prefixSumArray[i];
              if (sum == k || sum % k == 0) {
                  return true;
              }
          }
      }
        
      return false;
  }
  ```
