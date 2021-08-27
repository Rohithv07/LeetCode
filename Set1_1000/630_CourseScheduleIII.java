class Solution {
    public int scheduleCourse(int[][] courses) {
        // sort based on lastday
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        // priorityQueue -> maxHeap and storing duration
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int [] course : courses) {
            int duration = course[0];
            int lastDay = course[1];
            // update the time witht the duration
            time += duration;
            // add the duration to the pq
            pq.add(duration);
            // check if the time exceeds the lastday
            if (time > lastDay) {
                // subtract the time with current maximum at the top of the queue
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}
