class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int length = fruits.length;
        int maximumFruit = 0;
        int currentPrefixSumFruit = 0;
        for (int low = 0, high = 0; high < length; high++) {
            currentPrefixSumFruit += fruits[high][1];
            while (low < length && !canReachInKSteps(startPos, Math.min(startPos, fruits[low][0]), 
                                                    Math.max(startPos, fruits[high][0]), k)) {
                currentPrefixSumFruit -= fruits[low][1];
                low++;
            }
            maximumFruit = Math.max(maximumFruit, currentPrefixSumFruit);
        }
        return maximumFruit;
    }
    
    public boolean canReachInKSteps(int startPos, int low, int high, int k) {
        int lowLength = startPos - low;
        int highLength = high - startPos;
        return 2 * lowLength + highLength <= k || 2 * highLength + lowLength <= k;
    }
}