# Generate All Product of Array except Current Element

## Alias
- Leetcode (238): [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

## Problem
- Return an output array which each element is equal to the product of all the elements of the intput array except the current element in the input array.

## Solutions
- Solution 1
  ```java
  public int[] productExceptSelf(int[] nums) {
      int productOfArray                 = 1;                 // The product of all elements
      int productOfArrayWithoutFirstZero = 1;                 // The product of all elements except the first 0
      int numOfZero                      = 0;                 // The number of 0
        
      for (int i = 0; i < nums.length; i++) {
          productOfArray = productOfArray * nums[i];
          if (nums[i] == 0) {
              if (numOfZero != 0) {                           // For productOfArrayWithoutFirstZero, ignore the first 0, but rest 0s will count
                  productOfArrayWithoutFirstZero = productOfArrayWithoutFirstZero * nums[i];
              }
                
              numOfZero++;
          } else {
              productOfArrayWithoutFirstZero = productOfArrayWithoutFirstZero * nums[i];
          }
      }
        
      int[] answer = new int[nums.length];
        
      for (int i = 0; i < nums.length; i++) {
          if (nums[i] == 0) {
              if (numOfZero == 1) {                           // If the current element is 0 and num of 0 is one, use productOfArrayWithoutFirstZero directly
                  answer[i] = productOfArrayWithoutFirstZero;
              } else {                                        // If there are more than 1 zero, all the product will be 0
                  answer[i] = 0;
              }
          } else if (numOfZero > 0) {                         // If the current element is not 0, but if there are more than 1 zero, 
              answer[i] = 0;                                  // all product except the current element will be 0
          } else {
              answer[i] = productOfArray / nums[i];           // If the current element is not 0, but if there is no 0,
          }                                                   // all product except current = All product / current
      }
        
      return answer;
  }
  ```
