class Solution {
    public String firstPalindrome(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Palindrome palindrome = new Palindrome();
        for (String s : words) {
            if (palindrome.isPalindrome(s)) {
                return s;
            }
        }
        return "";
    }
}

class Palindrome {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}