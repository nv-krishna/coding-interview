# Get All Possible Strings by Removing Minimum Number of Invalid Parentheses

## Alias
- Leetcode (301): [Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/)

## Problem
- Get all the possible valid parenthesis strings by removing minimum number of invalid parentheses.

## Solutions
- Solution 1: Backtracking
   - Basic idea
      - For each character, there are 2 choices: Keep or remove.
      - So for each character, use recursion to find all the possible solutions after keeping or removing the current character.
   - Process
      - Recurse through each character from left to right, for each character
         - If the current character is not parenthesis:
            - Keep the character and recurse to the next character.
         - If the current character is a parenthesis:
            - Keep the character and recurse to the next character.
            - Remove the character and recurse to the next character.
   - Backtracking analysis
      - Element: Each character
      - Choices: Keep or remove
      - Constraints
         - If it's an right parentthese, only recurse if rightCount < leftCount
  ```java
  class Solution {
      private Set<String> validExpressions = new HashSet<String>();    // Store all the possible solutions
      private int minimumRemoved;                                      // Store the minimun number of parentheses have been removed
    
      public List<String> removeInvalidParentheses(String s) {
          this.reset();
          this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
          return new ArrayList(this.validExpressions);
      }
    
      private void reset() {
          this.validExpressions.clear();
          this.minimumRemoved = Integer.MAX_VALUE;
      }
    
      private void recurse(
          String s,
          int index,                                                     // The index of the current character
          int leftCount,                                                 // The number of left parentheses in the expression
          int rightCount,                                                // The number of right parentheses in the expression
          StringBuilder expression,                                      // The expression (potential solution) need to check
          int removedCount) {                                            // The number of parentheses have been removed

          if (index == s.length()) {                                     // If we have reached the end of string.
              if (leftCount == rightCount) {                             // If the current expression is valid.
                  if (removedCount <= this.minimumRemoved) {             // If the current num of removed parentheses <= the minimun num of removed parentheses
                      String possibleAnswer = expression.toString();

                      if (removedCount < this.minimumRemoved) {          // If the current num of removed parentheses beats the overall minimum we have till now
                          this.validExpressions.clear();                 // Clean the existing solution
                          this.minimumRemoved = removedCount;            // Update the minimun num of removed parentheses
                      }
                      this.validExpressions.add(possibleAnswer);         // Add the current expression into the solution list
                  }
              }
          } else {
              char currentCharacter = s.charAt(index);
              int length = expression.length();

              if (currentCharacter != '(' && currentCharacter != ')') {  // If the current character is not parenthesis,
                  expression.append(currentCharacter);                   // recurse further by adding it to the expression
                  this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
                  expression.deleteCharAt(length);
              } else {                                                   // If the current character is a parenthesis,
                  this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);   // Choice 1: Remove the current parenthesis and recurse further
                  expression.append(currentCharacter);
                                                                                                     // Choice 2: Keep the current parenthesis and recurse further
                  if (currentCharacter == '(') {                                                     //    If it's an left parenthesis, recurse further directly
                      this.recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
                  } else if (rightCount < leftCount) {                                               //    If it's an right parentthese, only recurse if rightCount < leftCount
                      this.recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
                  }
                
                  expression.deleteCharAt(length);                                                   // Undo the append operation for other recursions.
              }
          }
      }
  }
  ```

  ![Get_All_Possible_Strings_By_Removing_Minimum_Number_Of_Invalid_Parentheses](https://user-images.githubusercontent.com/8989447/117758249-e7845e80-b1de-11eb-9f49-11935ee6d6fb.png)
