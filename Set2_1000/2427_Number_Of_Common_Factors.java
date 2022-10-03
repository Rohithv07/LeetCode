class Solution {
    public int commonFactors(int a, int b) {
        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }
}