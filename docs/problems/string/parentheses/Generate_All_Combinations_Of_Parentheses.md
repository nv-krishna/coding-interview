# Generate All Combinations of Parentheses

## Alias
- Leetcode (22): [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)

## Problem
- All combinations of `n` parentheses.
- Return a list of all combinations.

## Solution
- Solution 1: Divide and conquer
   - A problem(n) can be separated as (+ is string concatenation)
      - `(` + problem(n-1) + `)`
      - problem(1)+problem(n-1), problem(2)+problem(n-2), problem(3)+problem(n-3), ...., problem(n-1)+problem(1)
  ```java
  public List<String> generateParenthesis(int n) {
      if (n == 1) {
          List<String> list = new ArrayList<>();
          list.add("()");
          return list;
      } else {
          List<String> previouList1 = generateParenthesis(n - 1);
          List<String> resultList = new ArrayList<>();
            
          for (String result : previouList1) {                         // Case 1: Add ( n-1 )
              currentList.add("(" + result + ")");
          }
            
          for (int i = 1; i < n; i++) {
              List<String> previouListA = generateParenthesis(i);      // Case 2: Add  merge(1,n-1), merge(2, n-2), ..., merge(n-1, 1)
              List<String> previouListB = generateParenthesis(n-i);

              for (String resultA : previouListA) {
                  for (String resultB : previouListB) {
                      if (!resultList.contains(resultA+resultB)) {
                          resultList.add(resultA+resultB);
                      }
                      if (!resultList.contains(resultB+resultA)) {
                          resultList.add(resultB+resultA);
                      }
                  }
              }
          }
            
          return currentList;
      }
  }
  ```
