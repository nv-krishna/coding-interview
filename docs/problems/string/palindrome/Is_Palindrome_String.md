# Is Palindrome String

## Problem
- Check the input string is palindrome or not.

## Solutions
- Solution 1: 2 pointers (meet pointers).
  ```java
  public boolean isPalindrome(String s) {
      if (s.length() == 0) {
          return false;
      }
        
      int i = 0;
      int j = s.length() - 1;
        
      boolean hasDelete = false;
        
      while (i<j) {
          char ci = s.charAt(i);
          char cj = s.charAt(j);
            
          if (s.charAt(i) == s.charAt(j)) {
              i++; 
              j--;
          } else {
              return false;
          }
      }
        
      return true;
  }
  ```
