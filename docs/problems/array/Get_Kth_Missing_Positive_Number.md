# Get Kth Missing Positive Number

## Alias
- Leetcode (1539): [Kth Missing Positive Number](https://leetcode.com/problems/kth-missing-positive-number/)

## Problem
- Considering positive integers 1,2,3,..., find the Kth missing number from the input array.
- The input array is sorted in ascending order.

## Examples
- Example 1
   - Input array: `[2,3,4,7,11]`
   - K: 5
   - 5th missing number: 9
   - Explanation
     
     ![mis](https://user-images.githubusercontent.com/8989447/118380219-583fc800-b59d-11eb-92cb-e351310801a8.png)

## Solutions
- Solution 1
  ```java
  public int findKthPositive(int[] arr, int k) {
      int i   = 0;      // Points to the current element in the array
      int num = 1;      // The current number
        
      while(i < arr.length || k > 0) {
          if (i < arr.length && num == arr[i]) {    // If the current number exists in the array, increase the i 
              i++;
          } else {
              k--;
              if (k == 0) {
                  return num;
              }
          }
            
          num++;
      }
        
      return num;
  }
  ```

