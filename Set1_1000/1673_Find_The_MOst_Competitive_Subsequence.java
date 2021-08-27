class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int length = nums.length;
        // we need to make use of a stack
        Stack<Integer> stack = new Stack<>();
        int [] result = new int [k];
        for (int i=0; i<length; i++) {
            // inside the stack we store the index and we need to check 3 situations
            // 1. stack is not empty
            // 2. current elment < nums[stack.peek()]
            // 3. length - i + stack.size() > k
            // if all these 3 satisfied then continue pop()
            // if our stack size < k, we need to push i
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()] && length - i + stack.size() > k)
                stack.pop();
            if (stack.size() < k)
                stack.push(i);
        }
        // now we have our elements index in the revese order. So store the elements to array correctly
        for (int i=k-1; i>=0; i--)
            result[i] = nums[stack.pop()];
        return result;
    }
}