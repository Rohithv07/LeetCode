class Solution {
    public int minimumLengthEncoding(String[] words) {
        Node trie = new Node();
        // each word add to trie
        for (String word : words) {
            add(trie, word);
        }
        return collect(trie); // collecting the length
    }
    
    public void add(Node trie, String word) {
        Node node = trie;
        for (int i=word.length()-1; i>=0; i--) {
            node = node.get(word.charAt(i));
        }
        node.word = word;
    }
    
    public int collect(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.count == 0)
            return node.word.length() + 1;
        int count = 0;
        for (Node n : node.next) {
            count += collect(n);
        }
        return count;
    }
}

class Node {
    Node [] next = new Node[26];
    int count = 0;  // children count
    String word = null;
    
    public Node get(char ch) {
        int i = ch - 'a';
        if (next[i] == null) {
            next[i] = new Node();
            count += 1;
        }
        return next[i];
    }
}
