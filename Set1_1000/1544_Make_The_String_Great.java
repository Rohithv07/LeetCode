/* My thought process
First I tried to create a new variable and individually check if charAt(i) == charAt(i+1)+32 and the vice versa and fill the new string excluding it. But I was not getting  a proper follow up, so I decided to look on the related topics of the qyestion and see a tag Stack.

So I thought in another way, 
I Just thought of pushing the elements into the stack and check whether character at stack == currentCharacter of string + 32 or -32 are equal, if yes, then we dont want that kind of bad character at our stack and we pop it out.
Else we just push it into the stack.
Now our required answer will be inside the stack but it will be in the reverse order as we know stack is LIFO.
So I convert the each and every element into the stack and reverse using the function reverse() and just converted to string and thats the problem.
*/
class Solution {
    public String makeGood(String s) {
        if (s.length() == 0)
            return "";
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char character = s.charAt(i);
            if (stack.isEmpty())
                stack.push(character);
            else if (character == stack.peek()+32 || character == stack.peek()-32)
                stack.pop();
            else
                stack.push(character);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
        
    }
}
