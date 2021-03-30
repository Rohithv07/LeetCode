class Solution {
    public int reinitializePermutation(int n) {
        int mid = n / 2;
        int x = n / 2;
        int count = 1;
        // take the count until x reach back to 1 which is the initial
        while (x != 1) {
            if (x % 2 == 1) {
                x = mid + x / 2;
            }
            else {
                x /= 2;
            }
            count += 1;
        }
        return count;
    }
}
