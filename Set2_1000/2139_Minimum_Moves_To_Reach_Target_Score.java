class Solution {
    public int minMoves(int target, int maxDoubles) {
        // here we can do reverse engineering
        // just start from the target and find the number of moves to reach 1
        // we will be forced to divide by 2 only if the target reaches an even value while doing operation
        // other wise decrement one
        if (maxDoubles == 0) {
            return target - 1;
        }
        int minimumMove = 0;
        while (target != 1 && maxDoubles > 0) {
            minimumMove += 1;
            if (target % 2 == 0) {
                target /= 2;
                maxDoubles -= 1;
            }
            else {
                target -= 1;
            }
        }
        if (target == 1) {
            return minimumMove;
        }
        return minimumMove + (target - 1);
    }
}