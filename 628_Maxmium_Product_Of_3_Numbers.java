class Solution {
    public int maximumProduct(int[] nums) {
        int minimum1 = Integer.MAX_VALUE;
        int minimum2 = Integer.MAX_VALUE;
        int maximum1 = Integer.MIN_VALUE;
        int maximum2 = Integer.MIN_VALUE;
        int maximum3 = Integer.MIN_VALUE;
        for (int number: nums) {
            if (number <= minimum1) {
                minimum2 = minimum1;
                minimum1 = number;
            }
            else if (number <= minimum2) {
                minimum2 = number;
            }
            if (number >= maximum1) {
                maximum3 = maximum2;
                maximum2 = maximum1;
                maximum1 = number;
            }
            else if (number >= maximum2) {
                maximum3 = maximum2;
                maximum2 = number;
            }
            else if (number >= maximum3) {
                maximum3 = number;
            }
        }
        return Math.max(minimum1*minimum2*maximum1, maximum1*maximum2*maximum3);
    }
}
