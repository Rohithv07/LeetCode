/* My though process:
Since for most of the paranthesis matching problem, we make use of stack, so here also a stack is used inorder to store some string.

First of all I simply check whether the string given is empty, if empty then we dont have any insertions to perform, so just return 0.
Now I traverse through the string given, when I see a ( then I just push its corresponding )) on to the stack.
If we dont encounter a (, then it means we have ) paranthesis, so we need to take care of certain things
-> We check whether we are not having another ) at the last, so if we dont have one, we have to insert one, so increment our count + 1
-> else we just increment our iterating variable
-> Another case to consider is that, whether we are not have a ( as the first character, so this can be checked by just checking whether our stack is empty or not, if its empty means we have not seen any (, so incrment our count + 1
-> Else we pop from the stack and outside the condition, we increment the iterarting variable.

Now there is a tricky with the result we have to return. We just didn't return our result, rather we need to take the double of the size of stack because for a single ( we require, 2 ) so we have to multiply by 2 for this mathching.
So we have to return count + size(stack) * 2
*/
class Solution {
    public int minInsertions(String s) {
        if (s.length() == 0)
            return 0;
        int count = 0;
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                stack.push("))");
                i ++;
            }
            else {
                if (i == s.length()-1 || s.charAt(i+1) != ')') {// not another ) 
                    count += 1;
                }
                else {
                    i += 1;
                }
                if (stack.isEmpty()) 
                    count += 1;
                else
                    stack.pop();
                i += 1;
            }
        }
        return count + stack.size() * 2;
    }
}
