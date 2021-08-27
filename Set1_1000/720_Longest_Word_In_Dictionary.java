class TrieNode {
    String ch;
    int wordEnd;
    TrieNode [] array = new TrieNode[26];
}

class Solution {
    
    TrieNode root = null;
    
    public Solution() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.array[index] == null) {
                node.array[index] = new TrieNode();
                node.array[index].wordEnd = 0;
            }
            node = node.array[index];
        }
        node.ch = word;
        node.wordEnd += 1;
    }
    
    public String findTheWord() {
        String result = "";
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TrieNode node = queue.poll();
                for (int j=25; j>=0; j--) {
                    if (node.array[j] != null && node.array[j].wordEnd != 0) {
                        result = node.array[j].ch;
                        queue.offer(node.array[j]);
                    }
                }
            }
        }
        return result;
    }
    
    
    public String longestWord(String[] words) {
        for (String word : words) {
            insert(word);
        }
        return findTheWord();
    }
}
