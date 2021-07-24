# Trie

- [**Concept**](#concept)
- [**Basic operations**](#basic-operations)
   - [Add word](#add-word)
   - [Search prefix](#search-prefix)
   - [Start with](#start-with)
   - [Is word](#is-word)
- [**References**](#references)

## Concept
- Rules
   - Each node store one character.
      - Root node store an empty character.
      - Each child node store an alphabet.
   - The path from the root to a leaf can construct a word.

     ![trie](https://user-images.githubusercontent.com/8989447/119071551-40a27e00-b9a7-11eb-817f-9f9b2a539d51.png)

- Code
   - Hash table implementation
     ```java
     class TrieNode {
         Map<Character, TrieNode> children;
         boolean isWord;                       // To indicate the node is a leaf or not
         public TrieNode() {
             this.children = new HashMap<>();
             this.isWord = false;
         }
     }
     ```

## Basic operations
### Add word
- Function
   - Add a word into trie.
- Code
  ```java
  public void addWord(TrieNode root, String word) {
      TrieNode node = root;

      for (char ch : word.toCharArray()) {
          if (!node.children.containsKey(ch)) {
              node.children.put(ch, new TrieNode());
          }
          node = node.children.get(ch);
      }
      node.word = true;
  }
  ```

### Search prefix
- Function
   - Search a prefix/word in trie.
   - Return the node which match the last character of the prefix.
- Code
  ```java
  private TrieNode searchPrefix(TrieNode root, String word) {
      TrieNode node = root;
      for (int i = 0; i < word.length(); i++) {
          char ch = word.charAt(i);
          if (node.containsKey(ch)) {
              node = node.get(ch);
          } else {
              return null;
          }
      }
      return node;
  }
  ```

### Start with
- Function
   - Check trie has a prefix or word or not.
- Code
  ```java
  public boolean startsWith(TrieNode root, String prefix) {
      TrieNode node = searchPrefix(root, prefix);
      return node != null;
  }
  ```

### Is word
- Function
   - Check trie has a word or not.
- Code
  ```java
  public boolean search(TrieNode root, String word) {
      TrieNode node = searchPrefix(root word);
      return node != null && node.isWord;
  }
  ```

## References
- https://en.wikipedia.org/wiki/Trie
- https://www.youtube.com/watch?v=zIjfhVPRZCg
