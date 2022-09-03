class Solution {
    public boolean findSubarrays(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int length = nums.length;
        Set<Integer> sum = new HashSet<>();
        for (int i = 0; i < length - 1; i++) {
            int num1 = nums[i];
            int num2 = nums[i + 1];
            int total = num1 + num2;
            if (sum.contains(total)) {
                return true;
            }
            sum.add(total);
        }
        return false;
    }
}