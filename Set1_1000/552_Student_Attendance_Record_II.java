// reference : https://leetcode.com/problems/student-attendance-record-ii/discuss/101643/Share-my-O(n)-C%2B%2B-DP-solution-with-thinking-process-and-explanation


class Solution {
    public int checkRecord(int n) {
        if (n == 1)
            return 3;
        int mod = (int)1e9 + 7;
        int [] p = new int [n];
        int [] a = new int [n];
        int [] l = new int [n];
        p[0] = 1;
        l[0] = 1;
        l[1] = 3;
        a[0] = 1;
        a[1] = 2;
        if (n > 2)
            a[2] = 4;
        for (int i=1; i<n; i++) {
            p[i - 1] %= mod;
            a[i - 1] %= mod;
            l[i - 1] %= mod;
            p[i] = ((a[i - 1] + p[i - 1]) % mod + l[i - 1]) % mod;
            if (i > 1) {
                l[i] = ((a[i - 1]  + p[i - 1]) % mod + (a[i - 2] + p[i - 2]) % mod) % mod;
            }
            if (i > 2) {
                a[i] = ((a[i - 1] + a[i - 2]) % mod + a[i - 3]) % mod;
            }
        }
        return ((a[n - 1] + p[n - 1]) % mod + l[n - 1]) % mod; 
    }
}
