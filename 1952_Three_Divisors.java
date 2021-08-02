class Solution {
    public boolean isThree(int n) {
        // inorder to have exactly 3 divisors, we need to follow : 
        // 1. n must be a perfect square
        // 2. sqrt(n) must be a prime number
        // then 1. prime, prime*prime=n - 3 factors
        if (n < 4)
            return false;
        int sqrt = (int)Math.sqrt(n);
        if (sqrt * sqrt != n)
            return false;
        for (int i=2; i*i<=sqrt; i++) {
            if (sqrt % i == 0)
                return false;
        }
        return true;
    }
}