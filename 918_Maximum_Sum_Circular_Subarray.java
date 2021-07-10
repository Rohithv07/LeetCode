// ref : https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/178422/One-Pass
// ref : https://www.youtube.com/watch?v=Q1TYVUEr-wY&list=PLEJXowNB4kPwR6C6yq3BzS-Jkyc6XE8kE&index=15


/*
The trick here is that to find the minimum subarray sum, we invert the sign of all the numbers in original subarray, and find the maximum subarray sum using Kadane algorithm. Then add it with the total sum. (which is similar to
[total - minimum subarray sum ])
*/

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        return Math.max(circularSum(nums, length), nonCircularSum(nums, length));
    }
    
    // normal kadane
    public int nonCircularSum(int [] nums, int length) {
        int max = nums[0];
        int currentMax = max;
        for (int i=1; i<length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            max = Math.max(max, currentMax);
        }
        return max;
    }
    
    // find totalSum, change the sign of array and calculate min subarray sum and we can use the above method. After that take circular sum as totalSum + nonCircularSum(sign changed array)
    public int circularSum(int [] nums, int length) {
        int totalSum = 0;
        int currentNonCircularSum = nonCircularSum(nums, length);
        int [] reversedSignNums = new int [length];
        for (int i=0; i<length; i++) {
            totalSum += nums[i];
            reversedSignNums[i] = -nums[i];
        }
        int circular = totalSum + nonCircularSum(reversedSignNums, length); //(equivalent as total - minsubarraysum)
        return circular == 0 ? currentNonCircularSum : circular;
    }
}

// one pass

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int maxStraight = Integer.MIN_VALUE;
        int minStraight = Integer.MAX_VALUE;
        int tempMax = 0;
        int tempMin = 0;
        int totalSum = 0;
        for (int i=0; i<length; i++) {
            totalSum += nums[i];
            tempMax += nums[i];
            maxStraight = Math.max(maxStraight, tempMax);
            tempMax = tempMax < 0 ? 0 : tempMax;
            tempMin += nums[i];
            minStraight = Math.min(minStraight, tempMin);
            tempMin = tempMin > 0 ? 0 : tempMin;
        }
        if (totalSum == minStraight)
            return maxStraight;
        return Math.max(maxStraight, totalSum - minStraight);
    }
}
