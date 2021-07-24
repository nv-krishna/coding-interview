# Is Palindrome String by Only Considering Alphanumeric Characters

## Alias
- Leetcode (125): [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)

## Problem
- Check the input string is palindrome or not.
- Consider only alphanumeric characters and ignoring cases.

## Solutions
- Solution 1: 2 pointers (meet pointers)
  ```java
  public boolean isPalindrome(String s) {
      char[] chars = s.toCharArray();
        
      int i = 0;
      int j = chars.length-1;
      while (i < j) {
          while (!(Character.isLetter(chars[i]) || Character.isDigit(chars[i])) && i < j) {
              i++;
          } 
          while (!(Character.isLetter(chars[j]) || Character.isDigit(chars[j])) && i < j) {
              j--;
          }
            
          if (Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[j])) {
              return false;
          }
          i++;
          j--;
      }
        
       eturn true;
  }
  ```
