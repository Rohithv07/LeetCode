class Solution {
    public String shortestPalindrome(String s) {
        
        // s is empty or length = 1
        if (s == "" || s.length() == 1)
            return s;
        // if s already palindrome
        if (isPalindrome(s))
            return s;
        // so the other part
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        // loop from backward until the first character as I consider the worst case that character as the middle one
        for (int i=length - 1; i>0; i--) {
            // add the last character.
            sb.append(s.charAt(i));
            String temp = sb.toString();
            // adding the remaining and checking palindrome achieved or not
            sb.append(s);
            String current = sb.toString();
            if (isPalindrome(current))
                return current;
            else {
                sb.setLength(0);
                sb.append(temp);
            }
        }
        // if the loop exit without finding one, append the string s to the sb
        sb.append(s);
        return sb.toString();
    }
    
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left += 1;
            right -= 1;
        }
        return true;
    }
}

/*
s = "" -> s is empty - return s
s = "a" -> return s
s = "aca" -> s is already a palindrome -> return s

s = "abc" -> s' = "cbabc" - return s'
s = "abcd" -> s' = "dcbabcd"


isPalindrome(s) -> true -> return s
                -> false -> we need to add characters to the front
                
s = "abcd"

sb = "dcbabcd"

let firstcharacter is s.charAt(0) = "a"
let length = n
for i =n -1 to 1:
    stringbuilder sb.append(s.charAt(i))
    
another case:
~~~~~~~~~~
s = "abbbac"
1st step sb = "c"
then add the remaining s and check for palindrome
sb = "cabbbac" -> true -> return sb
let length = n
for i =n -1 to 1:
    stringbuilder sb.append(s.charAt(i))
    sb.append(s)
    check if isPalindrome(sb.toString())
    
    
So generally
1) loop from the back if s is not already palindrome
2) add the last character + s and check for palindrome, if yes return it
3) else continue the loop until palindrome

This algorithm is O(n^2) and fails for the last 120th test case
So the efficient one is KMP algorithm.
*/
        
        // KMP Algo - Accepted- this is the correct accepted code. Above code fails in last test case
        String temp = s + "*" + new StringBuilder(s).reverse().toString();
        int [] kmpTable = getKMPTable(temp);
        return new StringBuilder(s.substring(kmpTable[kmpTable.length - 1])).reverse().toString() + s;
    }
    
    public int [] getKMPTable(String s) {
        int [] kmpTable = new int [s.length()];
        int index = 0;
        for (int i=1; i<s.length();) {
            if (s.charAt(index) == s.charAt(i)) {
                kmpTable[i] = ++index;
                i += 1;
            }
            else {
                if (index > 0) {
                    index = kmpTable[index - 1];
                }
                else {
                    index = 0;
                    i += 1;
                }
            }
        }
        return kmpTable;
    }
}
