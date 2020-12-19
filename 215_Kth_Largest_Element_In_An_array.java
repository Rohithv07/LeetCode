class Solution {
    public int findKthLargest(int[] nums, int k) {
        // this is a minHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int number: nums) {
            pq.add(number);
            if (pq.size() > k)
                pq.remove();
        }
        return pq.remove();
    }
}

// nlogk
