class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int number : stones) {
            pq.offer(number);
        }
        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            int result = Math.abs(stone2 - stone1);
            pq.offer(result);
        }
        return pq.poll();
    }
}
