# Calculate Dot Product of 2 Arrays

## Alias
- Leetcode (1570): [Dot Product of Two Sparse Vectors](https://leetcode.com/problems/dot-product-of-two-sparse-vectors/)

## Problem
- Calculate the dot product of 2 arrays.
- 2 arrays have the same length.
- The dot product is the sum of the products of the corresponding elements of the two arrays. 

  ![Screen Shot 2021-05-04 at 11 19 02 PM](https://user-images.githubusercontent.com/8989447/117099729-2aea5300-ad2f-11eb-85f8-d4324079b83a.png)
  
## Example
- Array 1: `[0,1,0,0,2,0,0]`
- Array 2: `[1,0,0,0,3,0,4]`
- Dot product: 6
- Explanation: 6 = 0 x 1 + 1 x 0 + 0 x 0 + 0 x 0 + 2 x 3 + 0 x 0 + 0 x 4

## Solutions
- Solution 1: HashMap
   - Create a HashMap to store non-0 element, key is index, value is the element.
   - For dot product, only calculate the entries in the HashMap.
  ```java
  class SparseVector {
      public Map<Integer, Integer> valueMap;
      public int size;
    
      SparseVector(int[] nums) {
          this.size = nums.length;
          this.valueMap = new HashMap<>();
          for (int i = 0; i < nums.length; i++) {
              if (nums[i] != 0) {                          // Only store non-zero
                  valueMap.put(i, nums[i]);
              }
          }
      }
    
	    // Return the dotProduct of two sparse vectors
      public int dotProduct(SparseVector vec) {
          int result = 0;
        
          for (int key : this.valueMap.keySet()) {
              if (vec.valueMap.get(key) != null) {         // If there is no corresponding entry in another HashMap
                                                           // it means the element in that position is 0, so ignore.
                  result = result + this.valueMap.get(key) * vec.valueMap.get(key);
              }
          }
        
          return result;
      }
  }
  ```
