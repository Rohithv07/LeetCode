class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long digitSum = sumOfDigit(n);
        if (digitSum <= target) {
            return 0;
        }
        long store = n;
        long multiplier = 1;
        while (sumOfDigit(n) > target) {
            n = n / 10 + 1;
            multiplier *= 10;
        }
        return n * multiplier - store;
    }
    
    
    private long sumOfDigit(long n) {
        long sum = 0;
        while (n > 0) {
            long rem = n % 10;
            sum += rem;
            n /= 10;
        }
        return sum;
    }
}