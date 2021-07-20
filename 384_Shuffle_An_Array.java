class Solution {

    private int [] nums;
    private Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null || nums.length == 0)
            return new int []{};
        int [] shuffled = nums.clone();
        for (int j=1; j<nums.length; j++) {
            // nextInt(j + 1) returns a random num between [0, j]. By nextInt(j), you never get a chance to return the original order array.
            int index = random.nextInt(j + 1);
            swap(shuffled, index, j);
        }
        return shuffled;
    }
    
    public void swap(int [] shuffled, int i, int j) {
        int temp = shuffled[i];
        shuffled[i] = shuffled[j];
        shuffled[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */