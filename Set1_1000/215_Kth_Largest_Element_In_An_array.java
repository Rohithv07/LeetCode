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



// quickselect

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return Integer.MAX_VALUE;
        // considering last element as the pivot
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    public int quickSelect(int [] nums, int start, int end, int k) {
        if (start > end)
            return Integer.MAX_VALUE;
        int pivot = nums[end];
        int left = start;
        for (int i=start; i<end; i++) {
            if (pivot >= nums[i]) {
                swap(nums, left++, i);
            }
        }
        swap(nums, left, end);
        if (left == k)
            return nums[left];
        if (left < k)
            return quickSelect(nums, left+1, end, k);
        return quickSelect(nums, start, left-1, k);
    }
    
    public void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


 indexOfPivot == k, return A[k]
else if indexOfPivot < k, keep checking right part to pivot
else if indexOfPivot > k, keep checking left part to pivot

