# Optimizing Box Weights

## Problem
- The robot need to separate N items into 2 boxes: Box A and Box B.
- The weight of each item is represented in the weight array: `weight[]`.
- There are the conditions need to be satified:
   - The intersection of Box A and Box B is null.
   - The union of Box A and Box B is equevilant to original weight array.
   - The number of elements in Box A is minimal.
   - The sum of Box A weights > The sum of Box B weights.
- Return the weights of items in the Box A.

## Solutions
- Solution 1
   - Sort the weight array in descending order.
   - Put one item from the beginning of the weight array (the heaviest item) into the Box A, until the Box A's weight is greater than the Box B's weight.
