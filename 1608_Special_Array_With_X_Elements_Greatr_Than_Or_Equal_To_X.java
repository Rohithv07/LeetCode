class Solution {
    public int specialArray(int[] nums) {
        if (nums.length == 1 && nums[0] == 0)
            return 0;
        int count = 0;
        for (int i=0; i<=nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                if (i <= nums[j]) {
                    count += 1;
                }
            }
            if (count == i)
                return i;
            else count = 0; 
        }
        return -1;
    }
}
