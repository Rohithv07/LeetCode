class Solution {
    public int subtractProductAndSum(int n) {
        // simple while loop will complete this problem
        if (n < 10)
            return 0;
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int rem = n % 10;
            sum += rem;
            product *= rem;
            n /= 10;
        }
        return product - sum;
    }
}
