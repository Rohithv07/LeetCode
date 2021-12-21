class Solution {
    public int maxSubArray(int[] nums) {
        // Kadanes algorithm
        int maximum_sum = nums[0];
        int current_sum = maximum_sum;
        for(int i = 1; i < nums.length; i++){
            current_sum = Math.max(nums[i] + current_sum, nums[i]);
            maximum_sum = Math.max(maximum_sum, current_sum);
        }
        return maximum_sum;
    }
}

/* Here we initialise a maximum sum as the first element of the arrays

 * Then we have current_sum initially the maximum sum
 
 * Now we loop through the array from the index of 1.
 
 * We update our current_sum taking maximum from  sum of number at ith index + current sum and  comparing with the initial current sum
 
 * Next we update our maximum_sum comparing with the current sum
 
 * Now just return the maximum sum and we get our answer.
*/



// another solution but same concept


class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int sum = 0;
        int max = nums[0];
        int startingIndex = 0;
        int endingIndex = 0;
        for (int i=0; i<length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
                endingIndex = i;
            }
            if (sum < 0) {
                sum = 0;
                startingIndex = i + 1;
            }
        }
        System.out.println(startingIndex + " " + endingIndex);
        return max;
    }
}
