class Solution {
    public int largestCombination(int[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return 0;
        }
        int result = 0;
        int current = 0;
        for (int i = 0; i < 30; i++) {
            current = 0;
            for (int candidate : candidates) {
                // atleast 1 bit must be set to have number > 0
                current += (candidate >> i) & 1;
            }
            result = Math.max(result, current);
        }
        return result;
    }
}