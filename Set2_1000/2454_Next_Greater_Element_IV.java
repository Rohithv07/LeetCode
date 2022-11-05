class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int length = nums.length;
        int [] result = new int [length];
        Arrays.fill(result, -1);
        // not found first greater element
        Stack<Integer> stack1 = new Stack<>();
        // found first greater element but not second greater
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> intermediate = new Stack<>();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (!stack2.isEmpty() && nums[stack2.peek()] < num) {
                result[stack2.pop()] = num;
            }
            while (!stack1.isEmpty() && nums[stack1.peek()] < num) {
                intermediate.push(stack1.pop());
            }
            while (!intermediate.isEmpty()) {
                stack2.push(intermediate.pop());
            }
            stack1.push(i);
        }
        return result;
    }
}