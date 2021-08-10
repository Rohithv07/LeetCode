class Solution {
    public int minFlipsMonoIncr(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int countOfOne = 0;
        int minFlip = 0;
        int zeroCountFromBack = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                countOfOne += 1;
            }
        }
        minFlip = countOfOne;
        for (int i=s.length() - 1; i>=0; i--) {
            if (s.charAt(i) == '0') {
                zeroCountFromBack += 1;
            }
            else {
                countOfOne -= 1;
            }
            minFlip = Math.min(zeroCountFromBack + countOfOne, minFlip);
        }
        return minFlip;
    }
}