class Solution {
    public int[] getOrder(int[][] tasks) {
        int length = tasks.length;
        int [] result = new int [length];
        int [][] enqueFlow = new int [length][3];
        // populate enqueFlow with index, enquetime, processingtime
        // the order is enqueFlow = [enquetime, processingtime, index]
        for (int i=0; i<length; i++) {
            enqueFlow[i][0] = tasks[i][0];
            enqueFlow[i][1] = tasks[i][1];
            enqueFlow[i][2] = i;
        }
        // sort the enqueFlow based on the enquetime
        Arrays.sort(enqueFlow, (a, b) -> a[0] - b[0]);
        // now push the elements inside it to the priorityqueue(minHeap)
        // the condition is based on shortest processing time + if there is an equality consider the index
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        // populate the element into the priorityqueue which will be arranged based on our priority
        int index = 0;
        int time = 0;
        int i = 0;
        while (i < length) {
            // start populating the pq
            while (i < length && enqueFlow[i][0] <= time) {
                pq.offer(enqueFlow[i]);
                i += 1;
            }
            // condition 1: if no task can be executed at time say time
            if (pq.isEmpty()) {
                time = enqueFlow[i][0];
            }
            // condition 2: if task can be executed, then continue and update time
            else if (!pq.isEmpty()) {
                int [] current = pq.poll();
                result[index++] = current[2];
                time += current[1];
            }
        }
        while (!pq.isEmpty()) {
            int [] current = pq.poll();
            result[index++] = current[2];
        }
        return result;
    }
}
