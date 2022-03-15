class Solution {
    public int countPoints(String rings) {
        if (rings == null || rings.length() < 6) {
            return 0;
        }
        int ringLength = rings.length();
        int length = ringLength / 2;
        int countEligibleRod = 0;
        boolean [] redTracker = new boolean [10];
        boolean [] blueTracker = new boolean [10];
        boolean [] greenTracker = new boolean [10];
        for (int i = 0; i < ringLength; i += 2) {
            char color = rings.charAt(i);
            int rod = rings.charAt(i + 1) - '0';
            if (color == 'R') {
                redTracker[rod] = true;
            }
            else if (color == 'B') {
                blueTracker[rod] = true;
            }
            else if (color == 'G') {
                greenTracker[rod] = true;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (redTracker[i] && blueTracker[i] && greenTracker[i]) {
                countEligibleRod++;
            }
        }
        return countEligibleRod;
    }
}