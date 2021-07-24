# Implement Trie

## Alias
- Leetcode (208): [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)

## Problem
- Implement a Trie class with the following functions
   - `Trie()`: Initializes the trie object.
   - `void insert(String word)`: Inserts the string word into the trie.
   - `boolean search(String word)`: Returns true if the string word is in the trie, and false otherwise.
   - `boolean startsWith(String prefix)`: Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

## Solution
- Solution 1: HashMap
  ```java
  class Trie {
      private TrieNode root;

      /** Initialize your data structure here. */
      public Trie() {
          this.root = new TrieNode();
      }
    
      /** Inserts a word into the trie. */
      public void insert(String word) {
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
    
      /** Returns if the word is in the trie. */
      public boolean search(String word) {
          TrieNode node = searchPrefix(word);
          return node != null && node.isWord;
      }
    
      /** Returns if there is any word in the trie that starts with the given prefix. */
      public boolean startsWith(String prefix) {
          TrieNode node = searchPrefix(prefix);
          return node != null;
      }
    
      public TrieNode searchPrefix(String prefix) {
          TrieNode node = this.root;
        
          for (int i = 0; i < prefix.length(); i++) {
              char ch = prefix.charAt(i);
            
              if (node.children.containsKey(ch)) {
                  node = node.children.get(ch);
              } else {
                  return null;
              }
          }
        
          return node;
      }
  }

  class TrieNode {
      public Map<Character, TrieNode> children;
      public boolean isWord;
    
      public TrieNode() {
          this.children = new HashMap<>();
      }
  }
  ```
