class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        using hashmap
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> subarraySum = new HashMap<>();
        subarraySum.put(0, 1);
        for (int number : nums) {
            sum = (((sum + number) % k) + k) % k;
            count += subarraySum.getOrDefault(sum, 0);
            subarraySum.put(sum, subarraySum.getOrDefault(sum, 0) + 1);
        }
        return count;
        
        // same approach using array of size k
        int [] subarray = new int [k];
        subarray[0] = 1;
        int count = 0;
        int prefixSum = 0;
        for (int number : nums) {
            prefixSum = (((prefixSum + number % k) + k) % k);
            count += subarray[prefixSum]++;
        }
        return count;
    }
}