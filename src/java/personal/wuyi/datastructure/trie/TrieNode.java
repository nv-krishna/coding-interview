package personal.wuyi.datastructure.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isWord;
    
    public TrieNode() {
        this.children = new HashMap<>();
    }
}
