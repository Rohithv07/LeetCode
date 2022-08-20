class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minSteps = k + 1;
        int count1 = 0;
        int count2 = 0;
        int length = blocks.length();
        for (int i = 0; i < length - k + 1; i++) {
            count1 = 0;
            count2 = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'B') {
                    count2++;
                }
                if (count2 == k) {
                    return 0;
                }
                else if (blocks.charAt(j) == 'W') {
                    count1++;
                    count2 = 0;
                }
            }
            minSteps = Math.min(minSteps, count1);
        }
        return minSteps;
    }
}