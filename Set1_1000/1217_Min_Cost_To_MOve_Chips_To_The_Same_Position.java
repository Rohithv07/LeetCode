class Solution {
    public int minCostToMoveChips(int[] position) {
        // here we just need to take the count of odd or even the position and return the minimum among them
        int even = 0;
        int odd = 0;
        for (int chips: position) {
            if (chips % 2 == 0)
                even += 1;
            else
                odd += 1;
        }
        return Math.min(even, odd);
    }
}
