class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count += 1;
            }
            else if (majority == nums[i]) {
                count += 1;
            }
            else {
                count -= 1;
            }
        }
        return majority;
    }
}


class Solution {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int number : nums) {
            if (count == 0) {
                candidate = number;
            }
            count += (number == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
