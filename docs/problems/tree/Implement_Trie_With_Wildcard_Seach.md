# Implement Trie with Wildcard Seach

## Alias
- Leetcode (211): [Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/)

## Problem
- Implement a Trie class with the following functions
   - `Trie()`: Initializes the trie object.
   - `void insert(String word)`: Inserts the string word into the trie.
   - `bool search(String word)`: Returns true if there is any string in the data structure that matches word or false otherwise. `word` may contain dots '.' where dots can be matched with any letter.

## Solution
- Solution 1: HashMap + Recursion
   - Implement a basic Trie.
   - In the search function, when finding a `.`, search all the children of the current node. If one of the children can match, return true.
  ```java
  class WordDictionary {
      private TrieNode root;

      public WordDictionary() {
          this.root = new TrieNode();
      }
    
      public void addWord(String word) {
          TrieNode node = this.root;
          for (int i = 0; i < word.length(); i++) {
              char ch = word.charAt(i);
            
              if (node.children.containsKey(ch)) {
                  node = node.children.get(ch);
              } else {
                  TrieNode newNode = new TrieNode();
                  node.children.put(ch, newNode);
                  node = newNode;
              }
          }
          node.isWord = true;
      }
    
      public boolean search(String word) {
          return searchInNode(word, this.root);
      }
    
      public boolean searchInNode(String word, TrieNode node) {
          for (int i = 0; i < word.length(); i++) {
              char ch = word.charAt(i);
            
              if (node.children.containsKey(ch)) {
                  node = node.children.get(ch);
              } else {
                  if (ch == '.') {                                           // If the current char is .
                      for (char x : node.children.keySet()) {                // search in all the children
                          TrieNode child = node.children.get(x);
                        
                          if (searchInNode(word.substring(i+1), child)) {    // If one of children can match, return true
                              return true;
                          }
                      } 
                      return false;                                          // If there is no child can match, return false
                  } else {
                      return false;
                  }
              }
          }
        
          return node.isWord;
      }
  }

  class TrieNode{
      public Map<Character, TrieNode> children;
      public boolean isWord;
    
      public TrieNode() {
          this.children = new HashMap<>();
          this.isWord = false;
      }
  }
  ```
