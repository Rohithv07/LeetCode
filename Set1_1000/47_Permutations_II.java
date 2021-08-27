class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        boolean [] used = new boolean[nums.length];
        helperFunction(result, current, nums, 0, used);
        return result;
    }
    public void helperFunction(List<List<Integer>> result, List<Integer> current, int [] nums, int start, boolean [] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=start; i<nums.length; i++) {
            if (used[i] || i > start && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            current.add(nums[i]);
            helperFunction(result, current, nums, 0, used);
            used[i] = false;
            current.remove(current.size()-1);
            
        }
    }
}
