class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int maxFloors = 0;
        int currentStandingFloor = bottom;
        for (int floor : special) {
            int remainingFloors = 0;
            if (currentStandingFloor <= floor) {
                remainingFloors = Math.abs(currentStandingFloor - floor);
                currentStandingFloor = floor + 1;
                maxFloors = Math.max(remainingFloors, maxFloors);
            }
        }
        if (currentStandingFloor < top) {
            maxFloors = Math.max(top - currentStandingFloor + 1, maxFloors);
        }
        return maxFloors;
    }
}