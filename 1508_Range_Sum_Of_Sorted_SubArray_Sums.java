class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int length = nums.length;
        List<Long> newArray = new ArrayList<>();
        long mod = 1000000007;
        long sum = 0;
        for (int i=0; i<length; i++) {
            for (int j=i; j<n; j++) {
                sum = 0;
                for (int k=i; k<=j; k++)
                    sum += nums[k];
                newArray.add(sum);
            }
        }
        Collections.sort(newArray);
        left -= 1;
        sum = 0;
        for (int i=left; i<right; i++) {
            sum = (sum + newArray.get(i)) % mod;
        }
        return (int) sum;
    }
}
