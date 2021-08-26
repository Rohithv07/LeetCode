class Solution {
    public int findGCD(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int smallest = 1001;
        int largest = 0;
        for (int number : nums) {
            smallest = Math.min(smallest, number);
            largest = Math.max(largest, number);
        }
        return gcd(smallest, largest);
    } // O(n) + O(log(smallest))
    
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}