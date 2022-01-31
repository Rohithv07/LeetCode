class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long left = 0;
        long right = Long.MAX_VALUE / n; // avg
        while (left <= right) {
            long middle = left + (right - left) / 2;
            if (canUseBattery(middle, batteries, n)) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return right;
    }
    
    public boolean canUseBattery(long middle, int [] batteries, int n) {
        long usedEnergy = 0;
        for (int battery : batteries) {
            usedEnergy += Math.min(battery, middle);
        }
        return usedEnergy >= middle * n;
    }
}