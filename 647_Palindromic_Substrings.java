class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 1)
            return 1;
        int length = s.length();
        int result = 0;
        for (int i=0; i<length; i++) {
            result += findPalindrome(s, i, i, length); // to check palindrome of odd length
            result += findPalindrome(s, i, i+1, length); // to check palindrome of even length
        }
        return result;
    }
    public int findPalindrome(String s, int left, int right, int length) {
        int temp = 0;
        while (left >= 0 && right <= length-1) {
            if (s.charAt(left) == s.charAt(right)) {
                left --;
                right += 1;
                temp += 1;
            }
            else
                break;
        }
        return temp;
    }
}
