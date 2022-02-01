class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long prefixSum = 0;
        long maxRange = 0;
        long minRange = 0;
        for (int diff : differences) {
            prefixSum += diff;
            maxRange = Math.max(maxRange, prefixSum);
            minRange = Math.min(minRange, prefixSum);
        }
        // upper - lower = max - min + k, then k + 1 is our answer
        // so k = upper - lower - max + min + 1
        return (int)(Math.max(0, upper - lower - maxRange + minRange + 1));
    }
}