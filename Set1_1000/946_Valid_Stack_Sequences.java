class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int length1 = pushed.length;
        int length2 = popped.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < length1 && j < length2) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j += 1;
            }
            i += 1;
        }
        return stack.isEmpty() ? true : false;


	// 2nd approach
        int i = 0;
        int j = 0;
        for (int number : pushed) {
            pushed[i++] = number;
            while (i > 0  && pushed[i - 1] == popped[j]) {
                j += 1;
                i -= 1;
            }
        }
        return i == 0;
    }
}


/*
pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Stack = [] -> [1] -> [1, 2] ->[1, 2, 3] -> [1, 2, 3, 4] -> [1, 2, 3] -> [1, 2,3, 5] -> [1, 2, 3] -> [1, 2] -> [1] -> [] - true


pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Stack = [] -> [1] -> [1, 2] -> [1, 2, 3] -> [1, 2, 3, 4] -> [1, 2, 3] -> [1, 2] -> [1, 2, 5] -> [1, 2] -> element ot be popped is 1 but the top is 2, so not possible and not a valid sequence 


*/
