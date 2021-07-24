# Prefix Sum Array

- [**Concepts**](#concepts)
- [**Benefit**](#benefit)
- [**Construction**](#construction)
- [**Conclusions**](#conclusions)
- [**Complexity**](#complexity)
- [**Problems can use this pattern**](#problems-can-use-this-pattern)
- [**References**](#references)

## Concepts
- Each element in a prefix sum array is the sum of all the elements which is in and before the current element of the input array.
- prefixSum[i] = input[0] + input[1] + ... + input[i] = prefixSum [i-1] + input[i]

  ![Untitled (3)](https://user-images.githubusercontent.com/8989447/115646395-4b51f080-a2df-11eb-9fd4-21315870d887.png)

## Benefit
- Reduce the complexity of algorithm from O(n<sup>2</sup>) to O(n).

## Construction
```
void buildPrefixSumArray(int[] nums) {
    int[] prefixSum[] = new int[nums.length];
    prefixSum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
        prefixSum[i] = prefixSum[i-1] + nums[i];
    }
}
```

## Conclusions
- The sum of range [i, j] of the input array: prefixSum[j] - prefixSum[i-1]

## Complexity
- Time complexity
   - O(n)
- Space complexity
   - O(n)

## Problems can use this pattern
- Sum of sub-array problems
   - [Get Equilibrium Index from Array](../../docs/problems/array/Get_Equilibrium_Index_From_Array.md)
   - [Count Sub-array Sum Equals K](../../docs/problems/array/Count_Sub_Array_Sum_Equals_K.md)
   - [Check Sub-array Sum Is Multiple of K](../../docs/problems/array/Check_Sub_Array_Sum_Is_Multiple_Of_K.md)
- Random candidate with different weight problems
   - [Generate Random Index with Weight](../../docs/problems/array/Generate_Random_Index_With_Weight.md)

## References
- https://en.wikipedia.org/wiki/Prefix_sum
- https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/
