class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int currentTotalUnit = 0;
        for (int [] box: boxTypes) {
            if (truckSize >= box[0]) {
                currentTotalUnit += box[0] * box[1];
                truckSize -= box[0];
            }
            else {
                currentTotalUnit += truckSize * box[1];
                return currentTotalUnit;
            }
        }
        return currentTotalUnit;
    }
}
