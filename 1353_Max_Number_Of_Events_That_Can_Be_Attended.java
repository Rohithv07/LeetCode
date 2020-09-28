/*
Steps for this question
1. Sort based on the first element of the events.
2. Make use of a priority queue for ease.
3. Add events that can be attendes on day d.
4. Remove events that are already closed.
5. Use day d to attend the event that closes earlier.
*/


class Solution {
    public int maxEvents(int[][] events) {
        int dayCount = 0;
        int i = 0;
        int n = events.length;
        Arrays.sort(events, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int d=1; d<=100000; d++) {
            while (i<n && events[i][0] == d)
                pq.add(events[i++][1]);
            while (!pq.isEmpty() && pq.peek() < d)
                pq.poll();
            if (!pq.isEmpty()) {
                dayCount += 1;
                pq.poll();
            }
        }
        return dayCount;
    }
}
