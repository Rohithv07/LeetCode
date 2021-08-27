class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length; 
        int [] positive = new int [n+1];
        int [] negative = new int [n+1];
        int result = 0;
        for (int i=1; i<=n; i++) {
            if (nums[i-1] < 0) {
                positive[i] = positive[i-1];
                negative[i] = negative[i-1]+1;
            }
            else if (nums[i-1] > 0) {
                positive[i] = positive[i-1]+1;
                negative[i] = negative[i-1];
            }
            if (negative[i] % 2 == 0)
                result = Math.max(result, positive[i] + negative[i]);
        }
        Arrays.fill(positive, 0);
        Arrays.fill(negative, 0);
        for (int i=n-1; i>=0; i--) {
            if (nums[i] < 0) {
                positive[i] = positive[i+1];
                negative[i] = negative[i+1]+1;
            }
            else if (nums[i] > 0) {
                positive[i] = positive[i+1]+1;
                negative[i] = negative[i+1];
            }
            if (negative[i] % 2 == 0)
                result = Math.max(result, positive[i] + negative[i]);
        }
        return result;
    }
}
