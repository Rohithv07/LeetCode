class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int refillCount = 0;
        int length = plants.length;
        int i = 0;
        int j = length - 1;
        int alice = capacityA;
        int bob = capacityB;
        while (i < j) {
            if (alice >= plants[i]) {
                alice -= plants[i];
            }
            else {
                refillCount++;
                alice = capacityA;
                alice -= plants[i];
            }
            if (bob >= plants[j]) {
                bob -= plants[j];
            }
            else {
                refillCount++;
                bob = capacityB;
                bob -= plants[j];
            }
            i++;
            j--;
        }
        if (length % 2 == 0) {
            return refillCount;
        }
        if (alice == bob) {
            if (plants[i] > alice) {
                refillCount++;
            }
        }
        else if (alice > bob) {
            if (plants[i] > alice) {
                refillCount++;
            }
        }
        else if (bob > alice) {
            if (plants[i] > bob) {
                refillCount++;
            }
        }
        return refillCount;
    }
}