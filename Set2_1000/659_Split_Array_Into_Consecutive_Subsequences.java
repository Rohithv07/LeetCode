// https://leetcode.com/problems/split-array-into-consecutive-subsequences/discuss/844738/Java-or-Very-easy-explanation-through-a-story-or-Time-O(n)-Space-O(n)
class Solution {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        Map<Integer, Integer> available = new HashMap<>();
        for (int number : nums) {
            available.put(number, available.getOrDefault(number, 0) + 1);
        }
        Map<Integer, Integer> vacancy = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            // not available
            if (available.get(nums[i]) <= 0) {
                continue;
            }
            // if there is a vacancy for the job
            else if (vacancy.getOrDefault(nums[i], 0) > 0) {
                available.put(nums[i], available.getOrDefault(nums[i], 0) - 1);
                vacancy.put(nums[i], vacancy.getOrDefault(nums[i], 0) - 1);
                vacancy.put(nums[i] + 1, vacancy.getOrDefault(nums[i] + 1, 0) + 1);
            }
            // if no vacancy, is there i, i + 1, i + 2 available to start a new company
            else if (available.getOrDefault(nums[i], 0) > 0 && available.getOrDefault(nums[i] + 1, 0) > 0 && available.getOrDefault(nums[i] + 2, 0) > 0) {
                available.put(nums[i], available.getOrDefault(nums[i], 0) - 1);
                available.put(nums[i] + 1, available.getOrDefault(nums[i] + 1, 0) - 1);
                available.put(nums[i] + 2, available.getOrDefault(nums[i] + 2, 0) - 1);
                // so these friends also given an opportunity for i + 3 to join the startup
                vacancy.put(nums[i] + 3, vacancy.getOrDefault(nums[i] + 3, 0) + 1);
            }
            // no job and no one to start a new comoany
            else {
                return false;
            }
        }
        return true;
        
    }
}