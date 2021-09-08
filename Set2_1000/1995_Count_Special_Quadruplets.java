class Solution {
    public int countQuadruplets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int count = 0;
        for (int i=0; i<length; i++) {
            for (int j=i+1; j<length; j++) {
                for (int k=j+1; k<length; k++) {
                    for (int l=k+1; l<length; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l])
                            count++;
                    }
                }
            }
        }
        return count;
    }
}