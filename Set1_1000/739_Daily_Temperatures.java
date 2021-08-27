
class Solution {
    public int[] dailyTemperatures(int[] T) {
        // we can try with the two pointers approach
        int length = T.length;
        int [] listOfTemp = new int [length];
        int left = 0;
        int right = 0;
        while (left < length) {
            if (right < length && T[left] < T[right]) {
                listOfTemp[left] = right - left;
                left += 1;
                right = left + 1;
            }
            else if (right < length){
                right += 1;
            }
            else {
                left += 1;
                right = left + 1;
            }
        }
        return listOfTemp;
    }
}


// this gets accepeted eventhough it is having high running time, is there any efficient one?
// we can try this with the stack as given in the related topics

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int [] listOfTemp = new int [n];
        Stack<Integer> stack = new Stack<>();
        for (int i=n-1; i>=0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()])
                stack.pop();
            listOfTemp[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return listOfTemp;
    }
}
