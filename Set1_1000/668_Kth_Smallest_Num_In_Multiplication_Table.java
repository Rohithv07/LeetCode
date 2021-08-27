class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (isSmaller(middle, m, n, k))
                right = middle;
            else
                left = middle + 1;
        }
        return left;
    }
    public boolean isSmaller(int middle, int m, int n, int k) {
        int count = 0;
        for (int i=1; i<=m; i++) {
            count += Math.min(middle/i, n);
        }
        return count >= k;
    }
}
