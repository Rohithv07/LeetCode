class Solution {
    public int getMaximumGenerated(int n) {
        int max = Integer.MIN_VALUE;
        if (n == 0)
            return 0;
        int [] nums = new int [n+1];
        nums[1] = 1;
        for (int i=1; i<=n; i++) {
            if (2*i <= n)
                nums[2*i] = nums[i];
            if (2*i + 1 <= n)
                nums[2*i+1] = nums[i] + nums[i+1];
        }
        for (int number: nums)
            max = Math.max(max, number);
        return max;
        //return Arrays.stream(nums).max().getAsInt();
    }
}
