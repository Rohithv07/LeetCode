/*
every time we find a duplicate we will increment ans by 1.
thus to check the second condition we will subtract the ans value from the index as we are shifting the element to the left.
for the last edge case we will check the remaining size after removing ans element from the vector if the result is odd we have to remove 1 more element else just return the ans.
*/

class Solution {
    public int minDeletion(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int removal = 0;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1] && (i - removal) % 2 == 0) {
                removal++;
            }
        }
        return removal + (length - removal) % 2;
    }
}