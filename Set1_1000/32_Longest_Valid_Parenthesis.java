class Solution {
    public int longestValidParentheses(String s) {
        int maxAnswer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // dummy
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }else {
                    maxAnswer = Math.max(maxAnswer, i - stack.peek());
                }
            }
        }
        return maxAnswer;
    }
}

// need to also check dp approach
