// most significant digit has the higher weightage
// we need to continue removing first peak
// we find the peek by finding the dip ie current element < top of the stack
// special care for numbers with 0
// leading zeros must be removed
// ref : https://www.youtube.com/watch?v=3QJzHqNAEXs&list=PLEJXowNB4kPwR6C6yq3BzS-Jkyc6XE8kE&index=13
class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = num.length();
        if (length == k) {
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<length; i++) {
            int number = num.charAt(i) - '0';
            while (!stack.isEmpty() && number < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            // we dont want any leading zeros
            if (stack.isEmpty() && number == 0)
                continue;
            stack.push(number);
        }
        // if there are still numbers to be removed, that is if k > 0, then just remove from the top of stack
        while (!stack.isEmpty() && k-- > 0)
            stack.pop();
         // for the case "10"
            //.             1
        if (stack.isEmpty()) {
            return "0";
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}