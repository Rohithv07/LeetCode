class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        // longest increasing subsequence with the given condition
        int length = nums.length;
        int max = 0;
        int index = -1;
        int [] lis = new int [length];
        int [] previous = new int [length];
        Arrays.fill(lis, 1);
        Arrays.fill(previous, -1);
        Arrays.sort(nums);
        for (int i=0; i<length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] % nums[j] == 0 && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    previous[i] = j;
                }
            }
            if (lis[i] > max) {
                max = lis[i];
                index = i;
            }
        }
        while (index != -1) {
            result.add(nums[index]);
            index = previous[index];
        }
        return result;
    }
}



/*

Another possible last section code

int previous = -1;
for (int i=length-1; i>=0; i--) {
    if (dp[i] == max && (previous % nums[i] == 0 || previous == -1)) {
    result.add(nums[i]);
    max = -1;
    previous = nums[i];
    }
}