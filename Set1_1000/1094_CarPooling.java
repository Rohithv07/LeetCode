/* 
My thought process
Initially I was a bit confused how to do this problem and I think whether I need to have a count of the 1st column and see whether the total count on that column if exceeds capacity will complete the work, but no, people gets out and gets in at different locations and we need to consider this too.
So I just looked through the authors solution and I see the main thing he highlighted about the constraint.
ie. 0 <= trips[i][1] < trips[i][2] <= 1000

Yes this will help us and I go through the solution and I liked it.

So we just need to create an array to store the number of people at different location where these index denotes the locations.
So after completing this array, we can just count the number of people and if it exceeds the capacity, then we must return false, otherwise we can return true.

So trip[0] = number of people, trip[1] = startign location trip[2] = ending location.

So if a person gets inside from a particular starting location, then we update the current location in the timestap by how many people gets inside the vehicle.
If person gets out after reaching the destination, then the number of people that is gets out is also marked.
Then counting these numbers and  comparing with the capacity will get our job done.

*/


class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int [] timeStamp = new int [1001];
        for (int [] trip: trips) {
            timeStamp[trip[1]] += trip[0];
            timeStamp[trip[2]] -= trip[0];
        }
        int currentCapacity = 0;
        for (int number: timeStamp) {
            currentCapacity += number;
            if (currentCapacity > capacity)
                return false;
        }
        return true;
    }
}
