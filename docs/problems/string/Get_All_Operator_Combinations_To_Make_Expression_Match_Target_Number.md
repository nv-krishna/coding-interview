# Get All Operator Combinations to Make Expression Match Target Number

## Alias
- Leetcode (282): [Expression Add Operators](https://leetcode.com/problems/expression-add-operators/)

## Problem
- Given a number in string and a target number, get all the combination of operators (`+`, `-`, `*`) which can be added between the digits of the number, so that the calculated result of the expression can match the target value.

## Examples
- Example 1
   - Number: "123"
   - Target: 6
   - Combinations: `["1*2*3","1+2+3"]`
- Example 2
   - Number: "232"
   - Target: 8
   - Combinations: `["2*3+2","2+3*2"]`
- Example 3
   - Number: "105"
   - Target: 5
   - Combinations: `["1*0+5","10-5"]`

## Solutions
- Solution 1: Backtracking
   - Basic idea
      - In the gap between each 2 digits, there are 4 operator can be added
         - No operator (Let 2 digits become a single number)
         - `+` operator
         - `-` operator
         - `x` operator
   - Process
      - Iterator from the first gap to the last gap of the number in string.
      - For each gap, recurse on 4 choices
         - No operator (Let 2 digits become a single number)
         - `+` operator
         - `-` operator
         - `x` operator
      - At the end
         - If the value of the expression can match the target number, add the current combination into the result list.
   - Backtracking analysis
      - Element: Each gap for each 2 digits.
      - Choices: no operator and 3 operators.
      - Constraints: The value of the expression can match the target value.
  ```java
  class Solution {
      public ArrayList<String> answer;                            // The result list
      public String            digits;                            // The input number in string
      public long              target;                            // The target number
    
      public List<String> addOperators(String num, int target) {
          if (num.length() == 0) {
              return new ArrayList<String>();
          }

          this.target = target;
          this.digits = num;
          this.answer = new ArrayList<String>();
          this.recurse(0, 0, 0, 0, new ArrayList<String>());
          return this.answer;
      }
    
      public void recurse(
          int index,                                                // The index of the current operator position
          long previousOperand,                                     // The previou operand
          long remainDigit,                                         // The remain digit from last operation (if no operator for the last operation)
          long value,                                               // The current value
          ArrayList<String> ops) {                                  // The list of operators and operands
        
          String nums = this.digits;

          if (index == nums.length()) {                             // If we have reached the end of num
              if (value == this.target && remainDigit == 0) {       // If the current value matches the target value and no operand is not processed
                  StringBuilder sb = new StringBuilder();           // Build the string by combining all the operators and operand
                  ops.subList(1, ops.size()).forEach(v -> sb.append(v)); // Ignore the first element because the first is a operator
                  this.answer.add(sb.toString());
              }
              return;
          }
                                                        
          long currentOperand = remainDigit * 10 + Character.getNumericValue(nums.charAt(index));  // Add one more digit to the current operand
          String currentOperandInString = Long.toString(currentOperand);
          int length = nums.length();

          if (currentOperand > 0) {                                 // To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a valid operand
              recurse(index + 1, previousOperand, currentOperand, value, ops);  // Choice 1: No operator 
          }

          ops.add("+");                                                         // Choice 2: + operator
          ops.add(currentOperandInString);
          recurse(index + 1, currentOperand, 0, value + currentOperand, ops);
          ops.remove(ops.size() - 1);
          ops.remove(ops.size() - 1);

          if (ops.size() > 0) {
              ops.add("-");                                                     // Choice 3: - operator
              ops.add(currentOperandInString);
              recurse(index + 1, -currentOperand, 0, value - currentOperand, ops);
              ops.remove(ops.size() - 1);
              ops.remove(ops.size() - 1);

              ops.add("*");                                                     // Choice 4: x operator
              ops.add(currentOperandInString);
              recurse(
                  index + 1,
                  currentOperand * previousOperand,
                  0,
                  value - previousOperand + (currentOperand * previousOperand),
                  ops);
              ops.remove(ops.size() - 1);
              ops.remove(ops.size() - 1);
          }
      }
  }
  ```
