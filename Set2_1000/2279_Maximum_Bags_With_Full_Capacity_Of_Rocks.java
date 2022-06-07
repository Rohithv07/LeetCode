class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int length = rocks.length;
        for (int i = 0; i < length; i++) {
            rocks[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(rocks);
        int fullyFilledCount = 0;
        for (int i = 0; i < length && (rocks[i] - additionalRocks) <= 0; i++) {
            fullyFilledCount++;
            additionalRocks -= rocks[i];
        }
        return fullyFilledCount;
    }
}