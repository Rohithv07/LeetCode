class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> trackTheNumbers = new HashSet<>();
        int answer = 0;
        int currentSum = 0;
        int i = 0;
        int j = 0;
        int length = nums.length;
        while (i < length && j < length) {
            // if the number is not present inside the set, so that it is unique
            if (!trackTheNumbers.contains(nums[j])) {
                currentSum += nums[j];
                answer = Math.max(currentSum, answer);
                // add this to the set inorder to check for uniquness
                trackTheNumbers.add(nums[j]);
                j += 1;
            }
            else {
                // the element already inside the set, so not unique.
                // we subtract the number from the sum and remove the number from the set
                currentSum -= nums[i];
                trackTheNumbers.remove(nums[i]);
                i += 1;
            }
        }
        return answer;
    }
}
