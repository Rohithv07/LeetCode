class Solution {
    public String removeDuplicates(String s) {
        if (s == null || s.length() == 0)
            return "";
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            }
            else if (stack.peek() == ch) {
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

/*
"abbaca"

[c a]
*/
