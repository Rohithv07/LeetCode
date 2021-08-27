class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0 || tokens == null)
            return -1;
        Stack<Integer> stack = new Stack<>();
        // whenever we see number, we push it
        // whenever we see operator, pop last 2 elemnt, do the operaton, push it back
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            }
            else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            }
            else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
