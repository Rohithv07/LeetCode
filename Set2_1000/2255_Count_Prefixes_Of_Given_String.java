class Solution {
    
    private TrieNode root;
    public Solution() {
        this.root = new TrieNode();
    }
    
    private void insert(String s) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
        }
    }
    
    private int prefixCount(String [] words, String s) {
        int count = 0;
        for (String word : words) {
            TrieNode node = root;
            if (word.equals(s)) {
                count++;
                continue;
            }
            if (word.length() > s.length()) {
                continue;
            }
            int currentMovement = 0;
            for (int i = 0; i < Math.min(s.length(), word.length()); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.child[index] == null) {
                    break;
                }
                node = node.child[index];
                currentMovement++;
            }
            if (currentMovement == word.length()) {
                count++;
            }
        }
        return count;
    }
    
    public int countPrefixes(String[] words, String s) {
        insert(s);
        return prefixCount(words, s);
    }
}

class TrieNode {
    TrieNode [] child = new TrieNode[26];
}