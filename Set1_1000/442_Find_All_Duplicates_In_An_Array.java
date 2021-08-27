class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> output = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                output.add(index + 1);
            nums[index] = -nums[index];
        }
        return output;
    }
}
