class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return isPalindrome(a, b) || isPalindrome(b, a);
    }
    // checks upto which limit i, j we have palindromic substring is s1 and s2
    public boolean isPalindrome(String s1, String s2) {
        int i = 0;
        int j = s2.length() - 1;
        while (i < j) {
            if (s1.charAt(i) != s2.charAt(j))
                break;
            i += 1;
            j -= 1;
        }
        return validate(s1, i, j) || validate(s2, i, j);
    }
    // check wether the string in that particular range[i,j] is also palindrome
    public boolean validate(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i += 1;
            j -= 1;
        }
        return true;
    }
}
