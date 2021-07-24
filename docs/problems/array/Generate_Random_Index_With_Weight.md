# Generate Random Index with Weight

## Alias
- Leetcode (528): [Random Pick with Weight](https://leetcode.com/problems/random-pick-with-weight/)
- GeeksforGeeks: [Random number generator in arbitrary probability distribution fashion](https://www.geeksforgeeks.org/random-number-generator-in-arbitrary-probability-distribution-fashion/)

## Problem
- In the input array, each element is the weight of each element.
- Randomly return an index of the input array with probability proportional to its weight

## Example
- Input array: [1, 6, 2, 1]
- The probability of return 0: 1 / (1+6+2+1) = 1 / 10
- The probability of return 1: 6 / (1+6+2+1) = 6 / 10
- The probability of return 2: 2 / (1+6+2+1) = 2 / 10
- The probability of return 3: 1 / (1+6+2+1) = 1 / 10

## Analysis
- Get a random number with proportional probability like a person throws a ball into different ranges.
- The element with large weight would occupy a broader range on the line compared to the element with small weight.
- Different ranges are separated by the offsets.
- The offsets of the ranges are actually the prefix sums from a sequence of numbers.
- So the problem can be consider as
    - Generate a random number between 0 and the total weight.
    - See the random number drop in which range based on offsets (prefix sum array).
    - Pick the index of that range.

  ![Untitled (2)](https://user-images.githubusercontent.com/8989447/115642306-f2328e80-a2d7-11eb-8816-2562c6bf77e1.png)

## Solutions
- Solution 1: Prefix sum array
  ```java
  class Solution {
      private int[] prefixSums;
      private int totalSum;

      public Solution(int[] w) {
          this.prefixSums = new int[w.length];

          int prefixSum = 0;
          for (int i = 0; i < w.length; ++i) {
              prefixSum += w[i];
              this.prefixSums[i] = prefixSum;
          }
          this.totalSum = prefixSum;
      }

      public int pickIndex() {
          // Get a random number between 0 and totalSum
          double target = this.totalSum * Math.random();
          int i = 0;
        
          // Run a linear search to find which range that random number dropping in
          for (; i < this.prefixSums.length; ++i) {
              if (target < this.prefixSums[i])
                  return i;
          }
        
          // Give a default return (Should not reach here)
          return i - 1;
      }
  }
  ```
