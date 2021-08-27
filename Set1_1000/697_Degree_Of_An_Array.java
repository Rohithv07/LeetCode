class Solution {
    public int findShortestSubArray(int[] nums) {
        // to populate the numbers and its first occurance
        Map<Integer, Integer> firstOccurance = new HashMap<>();
        // to populate the number and the count
        Map<Integer, Integer> count = new HashMap<>();
        // the result we have to return
        int result = 0;
        // the degree of the array
        int degree = 0;
        for (int i=0; i<nums.length; i++) {
            // if the number is occuring for the first time, populaye it in map
            if (firstOccurance.get(nums[i]) == null) {
                firstOccurance.put(nums[i], i);
            }
            // find the count of occurance
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            // if the count is greater than the ccurrent count, updaye with the current degree and update result
            if (count.get(nums[i]) > degree) {
                degree = count.get(nums[i]);
                result = i - firstOccurance.get(nums[i]) + 1;
            }
            // if the count become equal to degree, it means we have another number which have the same count
            // eg [1, 1, 2, 3, 2] here 1 and 2 have occured two times
            // so we need to take the min(result)
            else if (count.get(nums[i]) == degree) {
                result = Math.min(result, i - firstOccurance.get(nums[i]) + 1);
            }
        }
        return result;
    }
}
