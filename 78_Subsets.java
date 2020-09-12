O(N * 2^N) as there are 2^N subsets.

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helperFunction(result, current, nums, 0);
        return result;
    }
    public void helperFunction(List<List<Integer>> result, List<Integer> current, int [] nums, int start) {
        result.add(new ArrayList<>(current));
        for (int i=start; i<nums.length; i++) {
            current.add(nums[i]);
            helperFunction(result, current, nums, i+1);
            current.remove(current.size()-1);
        }
    }
}
