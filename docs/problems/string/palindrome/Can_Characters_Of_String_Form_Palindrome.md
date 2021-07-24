# Can Characters of String Form Palindrome

## Alias
- Leetcode (266): [Palindrome Permutation](https://leetcode.com/problems/palindrome-permutation/)

## Problem
- Give a string, return true if the characters of string can form a palindrome

## Solutions
- Solution 1: Frequency counter
   - Count the frequency of unique letter.
   - The string can form palindrome only if
      - The number of letters which has a odd number of occurrences <= 1
  ```java
  public boolean canPermutePalindrome(String s) {
      int[] counter = new int[26];
      Arrays.fill(counter, 0);
        
      for (int i = 0; i < s.length(); i++) {
          char ch = s.charAt(i);  
          counter[ch-'a']++;
      }
        
      boolean hasOddCount = false;
      for (int i = 0; i < counter.length; i++) {
          if (counter[i] % 2 == 1) {
              if (hasOddCount) {
                  return false;
              } else {
                  hasOddCount = true;
              }
          }
      }
        
      return true;
  }
  ```
      
