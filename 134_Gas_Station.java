class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int total = 0;
        int sumGasLeft = 0;
        for (int i=0; i<gas.length; i++) {
            int currentGasLeft = gas[i] - cost[i];
            if (sumGasLeft >= 0) {
                sumGasLeft += currentGasLeft;
            }
            else {
                sumGasLeft = currentGasLeft;
                start = i;
            }
            total += currentGasLeft;
        }
        return total >= 0 ? start : -1;
    }
}


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int sum = gas[start] - cost[start];
        while (start > end) {
            if (sum >= 0) {
                sum += gas[end] - cost[end];
                end += 1;
            }
            else {
                start -= 1;
                sum += gas[start] - cost[start];
            }
        }
        if (sum >= 0)
            return start;
        return -1;
    }
}
