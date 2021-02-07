/*
Here, I created a prefix sum array and after building the array I sorted it and  took the absolute(firtsIndexNumber) + absolute(lastIndexNumber). This is our required answer;
*/
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int [] prefix = new int [nums.length + 1];
        prefix[0] = 0;
        for (int i=1; i<prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        Arrays.sort(prefix);
        return Math.abs(prefix[0]) + Math.abs(prefix[prefix.length - 1]);
        
        // without prefix array and sorting
        int sum = 0;
        int min = 0;
        int max = 0;
        for (int number : nums) {
            sum += number;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        return max - min;
    }
}
