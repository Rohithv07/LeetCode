class Solution {
    public String makeFancyString(String s) {
        if (s == null || s.length() == 0)
            return s;
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        int counter = 0;
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
                counter = 1;
            }
            else if (!stack.isEmpty() && stack.peek() != ch) {
                stack.push(ch);
                counter = 1;
            }
            else if (!stack.isEmpty() && stack.peek() == ch && counter != 2) {
                counter += 1;
                stack.push(ch);
            }
            else if (!stack.isEmpty() && stack.peek() == ch && counter == 2) {
                stack.pop();
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
        
        // another approach efficient
        int length = s.length();
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<length; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                counter += 1;
            }
            else {
                counter = 1;
            }
            if (counter < 3) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}