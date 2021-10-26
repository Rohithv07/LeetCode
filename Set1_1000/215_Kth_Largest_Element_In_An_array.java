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



    // quick select with video reference and more understanding in my case with comments

// https://www.youtube.com/watch?v=hGK_5n81drs


class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        int requiredIndex = length - k;
        // we know our result will be at length - k index
        return quickSelect(nums, k, requiredIndex, 0, length - 1);
    }
    
    public int quickSelect(int [] nums, int k, int requiredIndex, int left, int right) {
        // select the item at left as pivot and move that item to the right most end so that it doesn;t get effected;
        int pivot = nums[left];
        swap(nums, left, right);
        // reduce the partitioning search space to be right - 1
        int searchSpace = right - 1;
        int i = left;
        int j = left;
        // use two pointers i and j and compare jth element with the pivot element
        // if element is smaller, swap ith and jthe element and increase both i and j
        // else just increase j
        while (j <= searchSpace) {
            if (nums[j] <= pivot) {
                swap(nums, j, i);
                i++;
            }
            j++;
        }
        // now bring back the pibot element to the ith position
        // this will be the final posiition of that element after sorting the array
        swap(nums, i, right);
        // if this i = our required index, then this element is the kth largest
        if (i == requiredIndex) {
            return nums[i];
        }
        // if this index < required index, then there is no logic in checking to the left of this index, so we just reduce the search space of left bound to i + 1
        if (i < requiredIndex) {
            return quickSelect(nums, k, requiredIndex, i + 1, right);
        }
        // just the reverse logic and we reduce the search space of right bound to i - 1
        return quickSelect(nums, k, requiredIndex, left, i - 1);
    }
    
    public void swap(int [] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

