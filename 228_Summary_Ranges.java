class Solution {
    public List<String> summaryRanges(int[] nums) {
        // to return the result
        List<String> result = new ArrayList<>(nums.length);
        if (nums.length == 0)
            return result;
        for (int i=0; i<nums.length; i++) {
            int number = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i+1])
                i += 1;
            if (number != nums[i]) {
                StringBuilder sb = new StringBuilder();
                sb.append(number);
                sb.append("->");
                sb.append(nums[i]);
                result.add(sb.toString());
            }
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(number);
                result.add(sb.toString());
            }
        }
        return result;
    }
}
