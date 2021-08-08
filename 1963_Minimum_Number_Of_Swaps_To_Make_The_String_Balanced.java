class Solution {
    public int minSwaps(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        // make use of stack
        // if we find a pair, ie top of stack = [ and current char = ], pop
        // else push [
        // now we will be having equals amount of ] and [
        // then pair + 1 /2 will be the answer
        // O(n)space
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == '[' && ch == ']') {
                // we found.a pair and delete them
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        // stack,size() / 2 is because we consider the pair
        return (stack.size() / 2 + 1) / 2;
        
        
        // without stack
        // 2 pointers
        // left and right pointer
        // if we have left > 0 and a ] at the left most, then decrement left
        // else if we have ] at current position, inrement right
        // else increment left and we have [
        // left + 1 / 2 will be answer;
        int left = 0;
        int right = 0;
        for (int i=0; i<s.length(); i++) {
            if (left > 0 && s.charAt(i) == ']') {
                left -= 1;
            }
            else if (s.charAt(i) == ']') {
                right += 1;
            }
            else {
                left += 1;
            }
        }
        return (left + 1) / 2;
        
    }
}