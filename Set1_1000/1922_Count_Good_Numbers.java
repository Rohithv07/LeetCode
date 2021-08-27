class Solution {
    public int countGoodNumbers(long n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 5;
        int mod = (int)1e9 + 7;
        long result = n % 2 == 0 ? 1 : 5;
        long x = 4 * 5;
        for (long i = n / 2; i > 0; i /= 2, x *= x, x %= mod) {
            if (i % 2 != 0) {
                result *= x;
                result %= mod;
            }
        }
        return (int) result;
    }
}

/*

For even indexes, there are 5 options: 0, 2, 4, 6, 8;
For odd indexes, there are 4 options: 2, 3, 5, 7;
If n is even, the solution is (4 * 5) ^ (n / 2); if odd, (4 * 5) ^ (n / 2) * 5.

*/
