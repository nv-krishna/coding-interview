# Strategies

## Problem-Solving Strategies
- When solving a interview problem, you need to give the brute force first and then think of optimal solution.

## Coding Strategies
- For getting better performance on searching, it is better to populate the elements into a `HashMap` and then search.
- Need to consider all possible cases for the input of your function:
   - If the input is String, the String can be empty: `str.isEmpty()`.
   - If the input is array, the array can be empty: `array.length == 0`.
- When converting a string to int, need to consider overflow.
```java
int i = 0;
String str = "999999999999999999999999999999999999999999";
try {
   i = Integer.parseInt(str);
} catch (Exception e) {
    /* some special handling */
}
```
- Some data structures/types are sorting the elements automatically:
   - `PriorityQueue`: Sort elements in ascending order automatically.
   - `TreeMap`: Sort entries by key in ascending order automatically.

## 2 Pointers
- Several ideas on 2 pointers for traversing an array:
   - 2 pointers on one end and approach toward another end (left->right or right->left).
   - 2 pointers on each end and approach toward the center.
   - Locate the center and change the width of the scanning window (c - w, c + w).
