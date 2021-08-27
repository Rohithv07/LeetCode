  
class TrieNode {
    TrieNode [] child = new TrieNode[26];
    boolean wordEnd;
}

class WordDictionary {

    private TrieNode root = null;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
        }
        node.wordEnd = true;
    }
    
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    public boolean match(char [] chs, int pos, TrieNode node) {
        if (pos == chs.length)
            return node.wordEnd;
        if (chs[pos] == '.') {
            for (int i=0; i<node.child.length; i++) {
                if (node.child[i] != null && match(chs, pos + 1, node.child[i])) {
                    return true;
                }
            }
        }
        else {
            return node.child[chs[pos] - 'a'] != null && match(chs, pos + 1, node.child[chs[pos] - 'a']);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
