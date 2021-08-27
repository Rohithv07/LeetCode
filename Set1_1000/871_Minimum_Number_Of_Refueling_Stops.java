class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int distance = startFuel;
        int result = 0;
        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (true) {
            while (index < stations.length && distance >= stations[index][0]) {
                pq.add(-stations[index++][1]);
            }
            if (distance >= target)
                return result;
            if (pq.isEmpty())
                return -1;
            distance += -pq.poll();
            result += 1;
        }
    }
}
