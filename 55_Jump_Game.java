class Solution {
    public boolean canJump(int[] nums) {
        int canReach = 0;
        for (int i=0; i <= canReach; i++){
            if (i == nums.length-1)
                return true;
            canReach = Math.max(canReach, i+nums[i]);
        }
        return false;
    }
}
