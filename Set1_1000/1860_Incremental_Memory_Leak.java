class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int counter = 1;
        boolean mem1Larger = false;
        boolean mem2Larger = false;
        if (memory1 >= memory2) {
            mem1Larger = true;
        }
        else {
            mem2Larger = true;
        }
        while (memory1 - counter >= 0 && memory2 - counter >= 0) {
            if (mem1Larger) {
                memory1 -= counter;
                if (memory1 >= memory2) {
                    mem1Larger = true;
                    mem2Larger = false;
                }
                else {
                    mem1Larger = false;
                    mem2Larger = true;
                }
            }
            else {
                memory2 -= counter;
                if (memory1 >= memory2) {
                    mem1Larger = true;
                    mem2Larger = false;
                }
                else {
                    mem1Larger = false;
                    mem2Larger = true;
                }
            }
            counter ++;
        }
        //counter -= 1;
        if (mem2Larger && memory2 - counter >= 0) {
            while (memory2 - counter >= 0) {
                memory2 -= counter;
                counter ++;
            }
        }
        else if (mem1Larger && memory1 - counter >= 0) {
            while (memory1 - counter >= 0) {
                memory1 -= counter;
                counter ++;
            }
        }
        return new int [] {counter, memory1, memory2};
    }
}

