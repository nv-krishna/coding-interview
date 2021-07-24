package personal.wuyi.datastructure.trie;

public class Trie {
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
