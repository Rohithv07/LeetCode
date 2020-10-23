class Solution {
    public boolean find132pattern(int[] nums) {
        // brute force O(n^3)
        /*if (nums.length < 3)
            return false;
        int n = nums.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int k=j+1; k<n; k++) {
                    int one = nums[i];
                    int two = nums[j];
                    int three = nums[k];
                    if (one < three && three < two)
                        return true;
                }
            }
        }
        return false;
        */
        // lets try to bring it down to O(n^2) and dont know whether it will work
        /*if (nums.length < 3)
            return false;
        int n = nums.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n-1; j++) {
                int one = nums[i];
                int two = nums[j];
                int three = nums[j+1];
                if (one < three && three < two)
                    return true;
            }
        }
        return false;
        */
        // but this solution is completely wrong but passes 86 of the test cases
        // so the main idea here is to make use of stack and also fidn the minimum from the given array
        if (nums.length < 3)
            return false;
        int n = nums.length;
        // we need a stack
        Stack<Integer> stack = new Stack<>();
        int [] min = new int [n];
        // fill the min array with minimum values
        min[0] = nums[0];
        for (int i=1; i<n; i++) 
            min[i] = Math.min(min[i-1], nums[i]);
        // now we need to traverse from the back and check for the element greater than the min
        for (int i=n-1; i>=0; i--) {
            if (nums[i] > min[i]) {
                // now we look into our stack and also check whther the top element is <= min[i]
                while (!stack.isEmpty() && stack.peek() <= min[i])
                    // we pops the element
                    stack.pop();
                // if the top element after poping is < nums[i], then we have min[i], stack.peek(), nums[i] in 132 fashion
                if (!stack.isEmpty() && stack.peek() < nums[i])
                    return true;
                stack.push(nums[i]);
            }
        }
        return false;
        // time complexity O(lengthOfArray)
        // space O(lengthOfArray) as the stack may grow upto the size of the array
    }
}
