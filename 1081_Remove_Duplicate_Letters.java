class Solution {
    public String removeDuplicateLetters(String s) {
        char [] sChar = s.toCharArray();
        int [] count = new int [26];
        Stack<Character> stack = new Stack();
        boolean [] visited = new boolean[26];
        // count occurance
        for (char c: sChar) {
            count[c-'a'] += 1;
        }
        for (char c: sChar) {
            count[c-'a'] -= 1;
            if (!visited[c-'a']) {
                while (!stack.isEmpty() && stack.peek()>c && count[stack.peek()-'a']>0) {
                    visited[stack.peek()-'a'] = false;
                    stack.pop();
                }
                stack.push(c);
                visited[c-'a'] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch: stack)
            sb.append(ch);
        return sb.toString();
    }
}
