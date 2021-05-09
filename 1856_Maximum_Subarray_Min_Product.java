class Solution {
    public int maxSumMinProduct(int[] nums) {
        int mod = (int)1e9 + 7;
        int length = nums.length;
        long [] prefixSum = new long[length + 1];
        int [] leftBound = new int [length];
        int [] rightBound = new int [length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop();
            if (stack.isEmpty()) {
                leftBound[i] = 0;
            }
            else {
                leftBound[i] = stack.peek() + 1;
            }
            stack.add(i);
        }
        stack =  new Stack<>();
        for (int i=length - 1; i>=0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                stack.pop();
            if (stack.isEmpty())
                rightBound[i] = length - 1;
            else
                rightBound[i] = stack.peek() - 1;
            stack.add(i);
        }
        for (int i=0; i<length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        long maxProduct = 0;
        for (int i=0; i<length; i++) {
            maxProduct = Math.max(maxProduct, findSum(leftBound[i], rightBound[i], prefixSum) * nums[i]);
        }
        return (int) (maxProduct %  mod);
    }
    
    public long findSum(int left, int right, long prefixSum []) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
