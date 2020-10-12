// since the given string is a palindrome, consider checking for half of the string only
// if we see a non 'a' here, replace it with 'a'
// if the string have only 'a', then replace the last character by b
// if string is empty- return ""
class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 0 || palindrome.length() == 1)
            return "";
        char [] ch = palindrome.toCharArray();
        int length = palindrome.length();
        for (int i=0; i<length/2; i++) {
            if (ch[i] != 'a') {
                ch[i] = 'a';
                return String.valueOf(ch);
            }
        }
        ch[length - 1] = 'b';
        return String.valueOf(ch);
    }
}
