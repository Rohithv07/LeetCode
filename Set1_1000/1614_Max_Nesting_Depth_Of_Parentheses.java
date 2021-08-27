// if we see an open parenthesis, increment a count and take the max of a varibale say result or the count.
// if we see a close parenthesis, decrement the count.
// finally return the result
class Solution {
    public int maxDepth(String s) {
        int result = 0;
        int current = 0;
        // traverse through the given string
        for (int i=0; i<s.length(); i++) {
            // check for the open parenthesis
            if (s.charAt(i) == '(') {
                current += 1;
                result = Math.max(result, current);
            }
            // check for the closed parenthesis
            else if (s.charAt(i) == ')')
                current -= 1;
        }
        return result;
    }
}
