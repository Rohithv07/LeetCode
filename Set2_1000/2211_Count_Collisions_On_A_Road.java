class Solution {
    public int countCollisions(String directions) {
        if (directions == null || directions.length() == 0) {
            return 0;
        }
        int length = directions.length();
        int collisionCount = 0;
        int movingPointer = 0;
        int rightMovingCarSeries = 0;
        // if we have so many cars at the beginning moving in left direction
        // then just ignore them as they will sure does not collide
        // only consider the remaining
        // from the remaining, calculate the number of vehicles in a series moving right
        // if we saw a S, increment the count by number of vehicle series going right
        // if we saw a L, increment the count by number of vehicles series going right + 1
        // in both case reset the right moving car to 0 and start fresh
        while (movingPointer < length && directions.charAt(movingPointer) == 'L') {
            movingPointer++;
        }
        while (movingPointer < length) {
            char currentDirection = directions.charAt(movingPointer);
            if (currentDirection == 'R') {
                rightMovingCarSeries++;
            }
            else {
                collisionCount += currentDirection == 'S' ? rightMovingCarSeries : rightMovingCarSeries + 1;
                rightMovingCarSeries = 0; // reset
            }
            movingPointer++;
        }
        return collisionCount;
    }
}