// handles both negative and positive numbers
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int totalSum = 0;
        for (int number : nums) {
            totalSum += number;
        }
        if (k <= 0 || totalSum % k != 0) {
            return false;
        }
        int length = nums.length;
        int [] visited = new int [length];
        return partition(nums, visited, k, 0, 0, 0, totalSum / k);
    }
    
    public boolean partition(int [] nums, int [] visited, int k, int startingIndex, int currentNumber, int currentSum, int target) {
        if (k == 1) {
            return true;
        }
        if (currentSum == target && currentNumber > 0) {
            return partition(nums, visited, k-1, 0, 0, 0, target);
        }
        for (int i=startingIndex; i<nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (partition(nums, visited, k, i+1, currentNumber++, currentSum + nums[i], target)) {
                    return true;
                }
                visited[i] = 0;   
            }
        }
        return false;
    }
}