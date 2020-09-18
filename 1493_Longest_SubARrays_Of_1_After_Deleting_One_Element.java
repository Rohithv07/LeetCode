/* 
We just create two arrays one to store the count of 1 from left to right and another for right to left.
When ever we see 0, we update the respectiove index of left or right by zero
else
we update the repective place by adding 1 with the previous value.      
    Eg: for left, left[i] = left[i-1]+1,     for right, right[i] = right[i+1]+1.
    For right we start from the end of the array and goes to the right.
    
Now we just need a max variable to keep track of themaximum and let it be 0 initially.
We goes throgh both the array and the max(max, left[i-1]+right[i+1])

Now finally we return max(max, max(right[2], left[arrayLength-2]))

Thats all..

*/
class Solution {
    public int longestSubarray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int n = nums.length;
        int [] left = new int [n];
        int [] right = new int [n];
        left[0] = nums[0];
        for (int i=1; i<n; i++) {
            if (nums[i] == 0)
                left[i] = 0;
            else
                left[i] = left[i-1] + 1;
        }
        right[n-1] = nums[n-1];
        for (int i=n-2; i>=0; i--) {
            if (nums[i] == 0)
                right[i] = 0;
            else
                right[i] = right[i+1] + 1;
        }
        int max = 0;
        for (int i=1; i<n-1; i++) {
            max = Math.max(max, left[i-1]+right[i+1]);
        }
        return Math.max(max, Math.max(right[2], left[n-2]));
    }
}
