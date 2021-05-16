class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result, current, nums, 0);
        int xor = 0;
        for (List<Integer> val : result) {
            int currentXor = 0;
            for (Integer value : val) {
                if (value != null)
                    currentXor ^= value;
            }
            xor += currentXor;
        }
        return xor;
        
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> current, int [] nums, int pos) {
        result.add(new ArrayList<>(current));
        for (int i=pos; i<nums.length; i++) {
            current.add(nums[i]);
            backtrack(result, current, nums, i+1);
            current.remove(current.size() - 1);
        }
    }
    
}
