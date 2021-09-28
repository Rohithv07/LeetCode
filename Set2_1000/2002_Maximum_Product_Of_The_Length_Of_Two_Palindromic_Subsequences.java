class Solution {
    
    private int maxProduct = -1;
    
    public int maxProduct(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        List<Character> word1 = new ArrayList<>();
        List<Character> word2 = new ArrayList<>();
        recursionHelper(s, 0, word1, word2);
        return maxProduct;
    }
    
    public void recursionHelper(String s, int currentIndex, List<Character> word1, List<Character> word2) {
        if (currentIndex >= s.length()) {
            // update the maxProduct by checking the palindrome
            if (isPalindrome(word1) && isPalindrome(word2)) {
                int length1 = word1.size();
                int length2 = word2.size();
                maxProduct = Math.max(maxProduct, length1 * length2);
            }
            return;
        }
        // otherwise consider other cases
        word1.add(s.charAt(currentIndex));
        recursionHelper(s, currentIndex + 1, word1, word2);
        // undo
        word1.remove(word1.size() - 1);
        // try the other possiblity with word2
        word2.add(s.charAt(currentIndex));
        recursionHelper(s, currentIndex + 1, word1, word2);
        // undo
        word2.remove(word2.size() - 1);
        // try possiblity without adding the char at index to both word1 and word2
        recursionHelper(s, currentIndex + 1, word1, word2);
    }
    
    public boolean isPalindrome(List<Character> word) {
        int size = word.size();
        int left = 0;
        int right = size - 1;
        while (left < right) {
            if (word.get(left++) != word.get(right--)) {
                return false;
            }
        }
        return true;
    }
}