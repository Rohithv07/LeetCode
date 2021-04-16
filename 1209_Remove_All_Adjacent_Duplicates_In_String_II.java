class Pair {
    char ch;
    int count;
    
    Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Pair> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == c) {
                stack.peek().count += 1;
            }
            else {
                stack.push(new Pair(c, 1));
            }
            if (stack.peek().count == k) {
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            for (int i=0; i<current.count; i++)
                sb.append(current.ch);
        }
        return sb.reverse().toString();
    }
}
