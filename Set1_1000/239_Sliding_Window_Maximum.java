class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int [] result = new int [length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i=0; i<length; i++) {
            // out of bound
            while (queue.size() > 0 && queue.peekFirst() <= i - k)
                queue.pollFirst();
            while (queue.size() > 0 && nums[queue.peekLast()] < nums[i])
                queue.pollLast();
            queue.offerLast(i);
            if (i >= k - 1)
                result[i - k + 1] = nums[queue.peekFirst()];
        }
        return result;
    }
}


// https://youtu.be/CZQGRp93K4k
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int []{};
        }
        int length = nums.length;
        final int resultSize = length - k + 1;
        int [] result = new int[resultSize];
        // now we will be making use of double ended queue deque
        Deque<Integer> queue = new ArrayDeque<>();
        int resultIndex = 0;
        for (int i=0; i<length; i++) {
            // we need to maintain the sliding window of size k
            if (!queue.isEmpty() && i - k == queue.peek()) {
                queue.poll();
            }
            // remove all the smaller element from end as we need to maintain a decreasing queue
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                result[resultIndex++] = nums[queue.peek()];
            }
        }
        return result;
    }
}
