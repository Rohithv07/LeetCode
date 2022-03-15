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


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrackHelper(nums, result, current, 0);
        return result;
    }
    
    public void backtrackHelper(int [] nums, List<List<Integer>> result, List<Integer> current, int position) {
        result.add(new ArrayList<>(current));
        for (int i=position; i<nums.length; i++) {
            current.add(nums[i]);
            backtrackHelper(nums, result, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}