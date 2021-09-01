class Solution {
    public int arrayNesting(int[] nums) {
        // O(n) space O(n) time
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int longest = 0;
        boolean [] visited = new boolean [length];
        for (int number : nums) {
            int currentLength = 0;
            while (!visited[number]) {
                visited[number] = true;
                currentLength += 1;
                number = nums[number];
            }
            longest = Math.max(longest, currentLength);
        }
        return longest;
        
        // O(1) space O(n) time
        int longest = 0;
        int length = nums.length;
        for (int i=0; i<length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int currentLength = 0;
                while (nums[i] != Integer.MAX_VALUE) {
                    int temp = nums[i];
                    nums[i] = nums[nums[i]];
                    currentLength ++;
                    nums[temp] = Integer.MAX_VALUE;
                }
                longest = Math.max(longest, currentLength);
            }
        }
        return longest;
    }
}