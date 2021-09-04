// brute force
class Solution {
    public int findMiddleIndex(int[] nums) {
        if (nums.length == 1)
            return 0;
        int totalSum = 0;
        int middleIndex = Integer.MAX_VALUE;
        int prefixSum = 0;
        // for (int number : nums) {
        //     totalSum += number;
        // }
        // if (totalSum - nums[0] == 0) {
        //     return 0;
        // }
        for (int i=1; i<nums.length; i++) {
            totalSum += nums[i];
        }
        if (totalSum == 0) {
            return 0;
        }
        for (int i=0; i<nums.length; i++) {
            prefixSum += nums[i];
            int sum = 0;
            for (int j=i+2; j<nums.length; j++) {
                sum += nums[j];
            }
            if (prefixSum == sum) {
                middleIndex = Math.min(i + 1, middleIndex);
            }
        }
        totalSum = 0;
        for (int i=nums.length - 2; i>=0; i--) {
            totalSum += nums[i];
        }
        if (totalSum == 0) {
            return Math.min(nums.length - 1, middleIndex);
        }
        return middleIndex == Integer.MAX_VALUE || middleIndex < 0 || middleIndex >= nums.length ? -1 : middleIndex;
    }
}

// another approach

// leftSum  = rightSum - nums[i]
// leftSum = (totalSum - leftSum) - nums[i]
// leftSum * 2 = totalSum - nums[i]
class Solution {
    public int findMiddleIndex(int[] nums) {
        if (nums.length == 1)
            return 0;
        int totalSum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i=0; i<nums.length; leftSum += nums[i++]) {
            if (leftSum * 2 == totalSum - nums[i])
                return i;
        }
        return -1;
    }
}

class Solution {
    public int findMiddleIndex(int[] nums) {
        if (nums.length == 1)
            return 0;
        int length = nums.length;
        int [] leftSum = new int [length];
        int [] rightSum = new int [length];
        leftSum[0] = nums[0];
        for (int i=1; i<length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
        }
        rightSum[length - 1] = nums[length - 1];
        for (int i=length-2; i>=0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }
        for (int i=0; i<length; i++) {
            if (leftSum[i] == rightSum[i]) {
                return i;
            }
        }
        return -1;
    }
}