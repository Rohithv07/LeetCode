class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int j = Math.abs(nums[i]) - 1;
            nums[j] = -1 * Math.abs(nums[j]);
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0)
                result.add(i+1);
        }
        return result;
    }
}
