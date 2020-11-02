class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        if (n == 1)
            return 0;
        int reachableBuilding = 0;
        for (int i=0; i<n-1; i++) {
            int currentBuilding = heights[i];
            int nextBuilding = heights[i+1];
            if (currentBuilding >= nextBuilding) {
                reachableBuilding += 1;
            }
            else {
                // 2 condition, we can use a brick or ladder
                // we use ladder when we have enough ladders and same way for bricks
                if (bricks > 0 && currentBuilding + bricks >= nextBuilding) {
                    bricks =  Math.abs(nextBuilding - currentBuilding - bricks);
                    reachableBuilding += 1;
                }
                else {
                    if (ladders > 0) {
                        ladders -= 1;
                        reachableBuilding += 1;
                    }
                    else
                        return reachableBuilding;
                }
            }
            
        }
        return reachableBuilding;
    }
}
