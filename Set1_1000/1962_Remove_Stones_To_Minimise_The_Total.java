// n + klogn
class Solution {
    public int minStoneSum(int[] piles, int k) {
        if (piles == null || piles.length == 0 || k < 0)
            return 0;
        int totalStones = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((stone1, stone2) -> Integer.compare(stone2, stone1));
        for (int stone : piles) {
            maxHeap.offer(stone);
            totalStones += stone;
        }
        while (k-- > 0) {
            int topStone = maxHeap.poll();
            int reconfigure = topStone - topStone / 2;
            totalStones -= topStone / 2;
            maxHeap.offer(reconfigure);
        }
        return totalStones;
    }
}



// slightly high runtime

class Solution {
    public int minStoneSum(int[] piles, int k) {
        if (piles == null || piles.length == 0 || k < 0)
            return 0;
        int totalStones = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((stone1, stone2) -> Integer.compare(stone2, stone1));
        for (int stone : piles) {
            maxHeap.offer(stone);
        }
        while (k-- > 0) {
            int topStone = maxHeap.poll();
            if (topStone % 2 == 1) {
                int reconfigure = (topStone / 2) + 1;
                maxHeap.offer(reconfigure);
            }
            else {
                int reconfigure = topStone / 2;
                maxHeap.offer(reconfigure);
            }
        }
        while (!maxHeap.isEmpty()) {
            totalStones += maxHeap.poll();
        }
        return totalStones;
    }
}