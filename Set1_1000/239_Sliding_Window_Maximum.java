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
