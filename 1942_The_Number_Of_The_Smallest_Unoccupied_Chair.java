/*
Approach:

Store the arrivalTime of targetFriend, since all the the arrival times are distinct this can be used to identify the targetFriend in sorted array.
Store all the available seats(one for each friend) in minHeap as available.
Sort the times array based on arrival time.
Maintain another minHeap to store leavingTime and occupiedSeat.
loop through sorted array
remove all the friends from the heap whose leavingTime is less than or equal to current arraival time and add the occupied seats back to available heap.
if the current start is equal to targetStart return the min available seat.
else add the current leaving time and min available seat to heap.
*/

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetStart = times[targetFriend][0];
        Arrays.sort(times, (t1, t2) -> Integer.compare(t1[0], t2[0]));
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i=0; i<times.length; i++) {
            available.offer(i);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i=0; i<times.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= times[i][0]) {
                available.offer(pq.poll()[1]);
            }
            if (times[i][0] == targetStart)
                break;
            pq.offer(new int [] {times[i][1], available.poll()});
        }
        return available.peek();
    }
}