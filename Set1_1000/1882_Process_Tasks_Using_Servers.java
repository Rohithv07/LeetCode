class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int lengthServer = servers.length;
        int lengthTasks = tasks.length;
        int [] result = new int [lengthTasks];
        PriorityQueue<int []> serverAvailable = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int []> serverUnavailable = new PriorityQueue<>((a, b)->(a[2] != b[2]) ? (a[2] - b[2]) : ((a[0] != b[0]) ? (a[0] - b[0]) : (a[1] - b[1])));
        for (int i=0; i<lengthServer; i++) {
            serverAvailable.offer(new int [] {servers[i], i, 0});
        }
        for (int i=0; i<lengthTasks; i++) {
            int currentTask = tasks[i];
            while (!serverUnavailable.isEmpty() && serverUnavailable.peek()[2] <= i) {
                serverAvailable.offer(serverUnavailable.poll());
            }
            if (serverAvailable.isEmpty()) {
                int [] current = serverUnavailable.poll();
                result[i] = current[1];
                current[2] += currentTask;
                serverUnavailable.offer(current);
            }
            else {
                int [] current = serverAvailable.poll();
                result[i] = current[1];
                current[2] = i + currentTask;
                serverUnavailable.offer(current);
            }
        }
        return result;
    }
}
