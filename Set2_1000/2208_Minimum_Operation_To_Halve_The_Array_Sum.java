class Solution {
    public int halveArray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        double totalSum = 0;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        for (int num : nums) {
            totalSum += num;
            maxHeap.offer((double)num);
        }
        double half = totalSum / 2.0;
        double currentSum = 0;
        int moves = 0;
        while (!maxHeap.isEmpty() && (totalSum - currentSum) > half) {
            double current = maxHeap.poll();
            current /= 2.0;
            currentSum += current;
            maxHeap.offer(current);
            moves++;
        }
        return moves;
    }
}