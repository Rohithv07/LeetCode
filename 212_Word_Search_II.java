class TrieNode {
    TrieNode [] next = new TrieNode[26];
    String word;
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = createTrie(words);
        int row = board.length;
        int col = board[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
    
    public void dfs(char [][] board, int i, int j, TrieNode root, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || root.next[board[i][j] - 'a'] == null)
            return;
        char temp = board[i][j];
        root = root.next[temp - 'a'];
        if (root.word != null) {
            result.add(root.word);
            root.word = null; // deals duplication
        }
        board[i][j] = '#';
        dfs(board, i, j-1, root, result);
        dfs(board, i, j+1, root, result);
        dfs(board, i-1, j, root, result);
        dfs(board, i+1, j, root, result);
        board[i][j] = temp;
    }
    
    public TrieNode createTrie(String [] words) {
        TrieNode root = new TrieNode();
        for (int i=0; i<words.length; i++) {
            String current = words[i];
            TrieNode node = root;
            for (char ch : current.toCharArray()) {
                int temp = ch - 'a';
                if (node.next[temp] == null)
                    node.next[temp] = new TrieNode();
                node = node.next[temp];
            }
            node.word = current;
        }
        return root;
    }
}


// 
