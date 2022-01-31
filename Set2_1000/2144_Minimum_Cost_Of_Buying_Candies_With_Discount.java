class Solution {
    public int minimumCost(int[] cost) {
        int length = cost.length;
        int minimumCost = 0;
        if (length < 3) {
            for (int number : cost) {
                minimumCost += number;
            }
            return minimumCost;
        }
        Arrays.sort(cost);
        int counter = 2;
        for (int i=length-1; i>=0; i--) {
            if (counter == 0) {
                counter = 2;
                continue;
            }
            minimumCost += cost[i];
            counter -= 1;
        }
        return minimumCost;
    }
}