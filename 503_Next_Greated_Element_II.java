class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int [] answer = new int[nums.length];
        Stack<Integer> stack = new Stack();
        for (int i = 2*nums.length - 1; i >= 0; i--) {
            // Here we take 2 * length - 1 as we need to look the cycle too
            while(!stack.empty() && nums[i % nums.length] >= nums[stack.peek()])
                stack.pop();
            if (!stack.empty())
                answer[i % nums.length] = nums[stack.peek()];
            else
                answer[i % nums.length] = -1;
            stack.push(i % nums.length);
        }
        return answer;
    }
}
