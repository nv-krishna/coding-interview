# Get All Word Combinations for Constructing String

## Alias
- Leetcode (140): [Word Break II](https://leetcode.com/problems/word-break-ii/)

## Problem
- Given a string and a dictionary of words, find all the combination of words can construct the string.
- Each words in the combinations should be separated by a single space.
- The same word in the dictionary may be reused multiple times.

## Examples
- Example 1
   - String: `catsanddog`
   - Dictionary: `["cat","cats","and","sand","dog"]`
   - All combinations: `["cats and dog","cat sand dog"]`

## Solutions
- Solution 1: Backtracking
   - Basic idea
      - For the string, it can be separated as: string = word + postfix.
      - We can use the same pattern on the postfix recursively.
   - Process
      - Use each word of the dictionary to match the prefix of the string.
         - For each word can match the prefix
            - Recurse on the postfix.
            - Add the word into the current combination.
      - When reach the end of the string
         - Add the current combination into the result list.
   - Backtracking analysis
      - Element: Each slot for one word (in the combination).
      - Choices: All the words in the dictionary.
      - Constraints: Prefix need to match one of the words from the dictionary.
  ```java
  class Solution {
      Set<String> wordSet     = new HashSet();                   // Store each words
      Set<Integer> wordLenSet = new HashSet();                   // Store each unique word length
      List<String> resultList = new ArrayList();
      int stringLength;
        
      public List<String> wordBreak(String s, List<String> wordDict) {
          stringLength = s.length();
          for (String word : wordDict) {
              wordSet.add(word);
              wordLenSet.add(word.length());
          }
          backtrack(s, 0, new LinkedList<String>());
          return resultList;
      }
    
      private void backtrack(
          String s, 
          int start,                                             // start is the start index of the postfix
          LinkedList<String> words) {                            // words is a list of words for the current combination
        
          if (start == stringLength) {                           // If we have reached the end of string.
              resultList.add(String.join(" ", words));           // Join all the words by space and add the current combination into the result list
              return;
          } else {
              for (int len : wordLenSet) { 
                  int end = start + len;
                  if (end <= stringLength) {
                      String word = s.substring(start, end);     // Get the substring from start position and end position    
                      if (wordSet.contains(word)) {              // If the substring is a word, 
                          words.addLast(word);                   // add the word into the current combination,
                          backtrack(s, end, words);              // recurse on the rest of string by moving start index to end index 
                          words.removeLast();
                      }   
                  }
              }
          }
      }
  }
  ```

  ![Get_All_Word_Combinations_For_Constructing_String drawio](https://user-images.githubusercontent.com/8989447/117890302-29aab000-b272-11eb-9cb5-84dbe2616142.png)
