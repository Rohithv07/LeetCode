class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        helperFunction(result, current, nums, 0);
        return result;
    }
    public void helperFunction(List<List<Integer>> result, List<Integer> current, int [] nums, int start) {
        result.add(new ArrayList<>(current));
        for (int i=start; i<nums.length; i++) {
            if (i > start && nums[i] == nums[i-1])  // checks for the duplicates and skips them
                continue;
            current.add(nums[i]);
            helperFunction(result, current, nums, i+1);
            current.remove(current.size()-1);
        }
    }
}



