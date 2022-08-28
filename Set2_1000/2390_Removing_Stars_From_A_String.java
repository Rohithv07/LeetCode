/*
This is a straight forward implementation problem using stack.

If we are seeing a star, we need to remove that star + the character to the left.
Character to the left means, the previous character that we have seen. So stack is good to know the previous.

Now whenever we see a star, we just do a pop operation, otherwise we do a push operation of that character.

We have our answer inside the stack in reverse order, make use of string builder and do a reverse before finally
returning the string.



*/



class Solution {
    public String removeStars(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char current = stack.pop();
            sb.append(current);
        }
        return sb.reverse().toString();
    }
}