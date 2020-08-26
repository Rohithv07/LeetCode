class Solution {
    public int findDuplicate(int[] nums) {
       /*
       Here there is changing the order of array by sorting, we can use cycle detection instead
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        for (int i=0; i<=nums.length-2; i++) {
            int result = nums[i] ^ nums[i+1];
            if (result == 0)
                return nums[i];
        }
        return 0;
        */
        int tortoise = nums[0];
        int hare = nums[0];
        while (true) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
            if (tortoise == hare)
                break;
        }
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return tortoise;
    }
}
