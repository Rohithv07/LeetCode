class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int calculate = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                calculate = calculate * 10 + s.charAt(i) - '0';
            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length() - 1) {
                if (sign == '+')
                    stack.push(calculate);
                else if (sign == '-')
                    stack.push(-calculate);
                else if (sign == '*')
                    stack.push(stack.pop() * calculate);
                else if (sign == '/')
                    stack.push(stack.pop() / calculate);
                sign = s.charAt(i);
                calculate = 0;
            }
        }
        int result = 0;
        for (int items: stack)
            result += items;
        return result;
    }
}
