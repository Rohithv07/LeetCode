/*

My thought process:
Here we only need to find the maximum difference of consecutive numbers from horizontalCuts and verticalCuts and take their product and it will be the maximum area.

*/

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxHDiff = 0;
        long maxVDiff = 0;
        int previousVal = 0;
        int mod = 1000000007;
        for (int cuts: horizontalCuts) {
            maxHDiff = Math.max(maxHDiff, cuts-previousVal);
            previousVal = cuts;
        }
        maxHDiff = Math.max(maxHDiff, h-previousVal);
        previousVal = 0;
        for (int cuts: verticalCuts) {
            maxVDiff = Math.max(maxVDiff, cuts-previousVal);
            previousVal = cuts;
        }
        maxVDiff = Math.max(maxVDiff, w-previousVal);
        long ans = maxHDiff % mod;
        ans = ans * (maxVDiff % mod);
        ans = ans % mod;
        return (int)ans;
    }
}
