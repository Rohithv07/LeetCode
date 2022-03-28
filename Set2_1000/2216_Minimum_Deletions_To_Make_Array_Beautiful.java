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


// another approach same idea : https://www.youtube.com/watch?v=A98psR_mIMQ

class Solution {
    public int minDeletion(int[] nums) {
        int length = nums.length;
        int removal = 0;
        for (int i = 0; i < length - 1; i++) {
            int shiftIndex = i - removal;
            if (nums[i] == nums[i + 1] && shiftIndex % 2 == 0) {
                removal++;
            }
        }
        if ((length - removal) % 2 == 1) {
            removal++;
        }
        return removal;
    }
}