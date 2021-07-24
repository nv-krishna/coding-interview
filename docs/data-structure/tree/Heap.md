# Heap

- [**Concept**](#concept)
- [**Types**](#types)
- [**Array Representation**](#array-representation)
- [**Basic operations**](#basic-operations)
   - [Insert](#insert)
   - [Extract](#extract)
- [**References**](#references)

## Concept
- Complete binary tree.
- The key stored in each node is either greater than or equal to (≥) or less than or equal to (≤) the keys in the node's children.

## Types
- **Max heap**
   - The parent key is greater than or equal to (≥) the child keys.
   - The root has the max key.
   
     ![max_heap](https://user-images.githubusercontent.com/8989447/116179688-ffcf8600-a6d4-11eb-8485-0399871a804e.png)


- **Min head**
   - The parent key is less than or equal to (≤) the child keys.
   - The root has the min key.
   
     ![min_heap](https://user-images.githubusercontent.com/8989447/116179698-03630d00-a6d5-11eb-90b3-83c4933b9a4a.png)
     
## Array Representation
- Left  = Index x 2 + 1
- Right = Index x 2 + 2
- Parent = RoundDown((Index - 1) / 2)

![heap_array](https://user-images.githubusercontent.com/8989447/116182267-2e4f6000-a6d9-11eb-8acb-684198d741ea.png)

## Basic operations
### Insert
- Process
   - Add the new node to the bottom level of the heap at the leftmost open space.
   - Compare the new node with its parent: 
      - If they are in the correct order, stop.
      - If they are NOT in the correct order, swap the new node with its parent. Continue this step.
### Extract
- Process
   - Replace the root of the heap with the last element on the last level.
   - Compare the new root with its children: 
      - If they are in the correct order, stop.
      - If they are NOT in the correct order, swap the new node with one of its children. Continue this step.
   
## References
- https://en.wikipedia.org/wiki/Heap_(data_structure)
- https://en.wikipedia.org/wiki/Binary_heap
- https://www.youtube.com/watch?v=t0Cq6tVNRBA
