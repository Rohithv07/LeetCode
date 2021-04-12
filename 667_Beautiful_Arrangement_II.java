class Solution {
    public int[] constructArray(int n, int k) {
        int [] result = new int [n];
        result[0] = 1;
        for (int i=1; i<=k; i++) {
            if (i % 2 == 1) {
                result[i] = result[i - 1] + (k - i + 1);
            }
            else {
                result[i] = result[i - 1] - (k - i + 1);
            }
        }
        for (int i=k+1; i<n; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
