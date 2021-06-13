// https://leetcode.com/problems/palindrome-pairs/discuss/79195/O(n-*-k2)-java-solution-with-Trie-structure
class Solution {
    
    private TrieNode root = new TrieNode();
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length == 0)
            return result;
        for (int i=0; i<words.length; i++) {
            insert(words[i], i);
        }
        for (int i=0; i<words.length; i++) {
            search(words[i], i, result);
        }
        return result;
    }
    
    public void insert(String word, int index) {
        TrieNode node = root;
        for (int i=word.length() - 1; i >= 0; i--) {
            int ind = word.charAt(i) - 'a';
            if (node.array[ind] == null) {
                node.array[ind] = new TrieNode();
            }
            if (isPalindrome(word, 0, i)) {
                node.list.add(index);
            }
            node = node.array[ind];
        }
        node.list.add(index);
        node.index = index;
    }
    
    public void search(String words, int index, List<List<Integer>> result) {
        TrieNode node = root;
        for (int j=0; j<words.length(); j++) {
            if (node.index >= 0 && node.index != index && isPalindrome(words, j, words.length() - 1)) {
                result.add(Arrays.asList(index, node.index));
            }
            node = node.array[words.charAt(j) - 'a'];
            if (node == null)
                return;
        }
        for (int value : node.list) {
            if (index == value)
                continue;
            result.add(Arrays.asList(index, value));
        }
    }
    
    
    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right --))
                return false;
        }
        return true;
    }
}

class TrieNode {
    int index;
    List<Integer> list;
    TrieNode [] array;
    TrieNode() {
        index = -1;
        list = new ArrayList<>();
        array = new TrieNode[26];
    }
}
