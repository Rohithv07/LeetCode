class Solution {
    public int prefixCount(String[] words, String pref) {
        int prefixCount = 0;
        int prefixLength = pref.length();
        for (String word : words) {
            if (word.length() < prefixLength) {
                continue;
            }
            int index = 0;
            boolean prefixFound = true;
            while (index < prefixLength) {
                if (word.charAt(index) != pref.charAt(index)) {
                    prefixFound = false;
                    break;
                }
                index++;
            }
            if (prefixFound) {
                prefixCount++;
            }
        }
        return prefixCount;
    }
}


class Solution {
    
    private TrieNode root;
    public Solution() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TrieNode();
            }
            node.ch = ch;
            node = node.child[index];
            node.count++;
        }
        node.word = word;
    }
    
    public int prefixFinder(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.child[index] == null) {
                return 0;
            }
            node = node.child[index];
        }
        return node.count;
    }
    
    public int prefixCount(String[] words, String prefix) {
        int prefixCount = 0;
        for (String word : words) {
            insert(word);
        }
        return prefixFinder(prefix);
    }
}

class TrieNode {
    char ch;
    String word;
    int count = 0;
    TrieNode [] child;
    TrieNode(){
        this.child = new TrieNode[26];
    }
}