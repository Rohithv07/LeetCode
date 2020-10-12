// here there are 3 conditions that we want to consider
// 1. if the string is empty, then return 0. This can be our first check.
// 2. Next one is checking palindrome or not. If the whole string is palindrome, then we can delete it completely. So return 1.
// 3. The next one is either we can remove a completely then b or vice versa. So in this case number of steps will be only 2. 
    // That is first step can be to remove all 'a's and the second step is remove all 'b's.
class Solution {
    public int removePalindromeSub(String s) {
        // string empty
        if (s.length() == 0)
            return 0;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // palindrome condition
            if (s.charAt(left) == s.charAt(right)) {
                left += 1;
                right -= 1;
            }
            else 
                return 2;
        }
        return 1;
    }
}
