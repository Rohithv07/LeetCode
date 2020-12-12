class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int leftPart = 0;
        int rightPart = 0;
        // let the rightPart store the whole sum
        for (int number: nums)
            rightPart += number;
        int [] result = new int [nums.length];
        for (int i=0; i<nums.length; i++) {
            // subtract from the totalSum store in rightPart
            rightPart -= nums[i];
            // the sum is expressed as nums[i] - nums[0] + nums[i] - nums[1] ...... + num[i+1] - nums[i] + ....
            int fromLeft = nums[i] * i - leftPart;
            int fromRight = rightPart - (nums.length - i - 1) * nums[i];
            // now update the leftPart by adding with the nums[i]
            leftPart += nums[i];
            // the result will be fromLeft + fromRight
            result[i] = fromLeft + fromRight;
        }
        return result;
    }
}
