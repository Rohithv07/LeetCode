// Adding 1 to n - 1 elements is the same as subtracting 1 from one element, w.r.t goal of making the elements in the array equal.
class Solution {
    public int minMoves(int[] nums) {
        int length = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int number : nums) {
            sum += number;
            min = Math.min(min, number);
        }
        return sum - length * min;
    }
}
