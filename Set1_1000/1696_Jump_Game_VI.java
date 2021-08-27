class Solution {
    public int maxResult(int[] nums, int k) {
        int length = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i=0; i<nums.length; i++) {
            // 1. We find the current maximum from the updated array with the help of deque
            int currentMax = deque.isEmpty() ? 0 : nums[deque.peekFirst()];
            // we update the current nums[i] by adding with the current max.
            nums[i] = nums[i] + currentMax;
            // we only need the large values, so if we have small values than the updates nums[i], just remove the last element from the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            // add the index to the deque
            deque.add(i);
            // we can only jump i+1 or min(lenght - 1, i + k). So this boundary have to maintained. We poll from first inorder to maintain it.
            while (!deque.isEmpty() && i - deque.peekFirst() + 1 > k)
                deque.pollFirst();
        }
        return nums[nums.length - 1];
    }
}


 /*                         
[1, -1, -2, 4, -7, 3]


 10          14    17          
[10, -5, -2, 4, 0, 3]

 1  -4       0      3       0        
[1, -5, -20, 4, -1, 3, -6, -3]


*/
