# Is Palindrome String by Removing One Char

## Alias
- Leetcode (680): [Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/)

## Problem
- Check the input string is palindrome or not.
- You can delete at most one character.

## Solutions
- Solution 1: 2 pointers (meet pointers) + greedy
   - Use 2 meet pointers until left char is not same with right char.
   - Consider 2 substrings: One is [left, right-1], another is [left+1, right]
   - Check both substrings are palindrome or not (greedy):
      - If any of substring is palindrome, so the input string is palindrome.
      - If none of them is palindrome, so the input string is not palindrome.
  ```java
  public boolean validPalindrome(String s) {
      if (s.length() <= 2) {
          return true;
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
              String substr1 = s.substring(i, j);
              String substr2 = s.substring(i+1, j+1);
              boolean isStr1P = isPalindrome(substr1);
              boolean isStr2P = isPalindrome(substr2);
                
              if (isStr1P || isStr2P) {
                  return true;
              } else {
                  return false;
              }
          }
      }
        
      return true;
  }
  ```
