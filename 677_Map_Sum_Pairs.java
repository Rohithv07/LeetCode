class MapSum {

    /** Initialize your data structure here. */
    private TrieNode root;
    
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insertToTrie(String s, int val) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TrieNode();
                node.child[index].ch = ch;
            }
            node = node.child[index];
        }
        node.currentWordValue = val;
    }
    
    public int searchInTrie(String s) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (node.child[index] == null)
                return 0;
            node = node.child[index];
        }
        return findByDfs(node);
    }
    
    public void insert(String key, int val) {
        insertToTrie(key, val);
    }
    
    public int sum(String prefix) {
        return searchInTrie(prefix);
    }
    
    public int findByDfs(TrieNode node) {
        int sum = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (node.child[ch - 'a'] != null)
                sum += findByDfs(node.child[ch - 'a']);
        }
        return sum + node.currentWordValue;
    }
}

class TrieNode {
    char ch;
    int currentWordValue = 0;
    TrieNode[] child = new TrieNode[26];
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */