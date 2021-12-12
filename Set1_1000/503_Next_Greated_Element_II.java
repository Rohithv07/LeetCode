// when we are copying the array twice to new array of size 2 * length for dealing cycle

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int []{};
        }
        int length = nums.length;
        int [] result = new int [length];
        int [] copyArray = new int [2 * length];
        for (int i=0; i<2*length; i++) {
            copyArray[i] = nums[i % length];
        }
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i=2*length-1; i>=0; i--) {
            while (!stack.isEmpty() && nums[stack.peek() % length] <= copyArray[i]) {
                stack.pop();
            }
            if (i < length) {
                if (stack.isEmpty()) {
                    result[i % length] = -1;
                }
                else {
                    result[i % length] = copyArray[stack.peek()];
                }
            }
            stack.push(i);
        }
        return result;
    }
}

// without using extra copy array but by using Mod operator : https://youtu.be/Du881K7Jtk8

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int []{};
        }
        int length = nums.length;
        int [] result = new int [length];
        Stack<Integer> stack = new Stack<>();
        for (int i=2*length-1; i>=0; i--) {
            int currentNumber = nums[i % length];
            while (!stack.isEmpty() && stack.peek() <= currentNumber) {
                stack.pop();
            }
            if (i < length) {
                if (stack.isEmpty()) {
                    result[i % length] = -1;
                }
                else {
                    result[i % length] = stack.peek();
                }
            }
            stack.push(nums[i % length]);
        }
        return result;
    }
}




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
