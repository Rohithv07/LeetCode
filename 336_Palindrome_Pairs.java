class Solution {
    
    private Trie root = new Trie();
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length == 0)
            return result;
        for (int i=0; i<words.length; i++) {
            insert(words[i], i);
        }
        for (int i=0; i<words.length; i++) {
            search(words, i, result);
        }
        return result;
    }
    
    public void insert(String word, int index) {
        Trie node = root;
        for (int i=word.length()- 1; i>=0; i--) {
            int j = word.charAt(i) - 'a';
            if (node.array[j] == null) {
                node.array[j] = new Trie();
            }
            if (isPalindrome(word, 0, i)) {
                node.list.add(index);
            }
            node = node.array[j];
        }
        node.list.add(index);
        node.index = index;
    }
    
    public void search(String [] words, int i, List<List<Integer>> result) {
        Trie node = root;
        for (int j=0; j<words[i].length(); j++) {
            if (node.index >= 0 && node.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                result.add(Arrays.asList(i, node.index));
            }
            node = node.array[words[i].charAt(j) - 'a'];
            if (node == null)
                return;
        }
        for (int value : node.list) {
            if (i == value)
                continue;
            result.add(Arrays.asList(i, value));
        }
    }
    
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i ++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}

class Trie {
    int index;
    List<Integer> list;
    Trie [] array;
    Trie() {
        index = -1;
        list = new ArrayList<>();
        array = new Trie[26];
    }
}
