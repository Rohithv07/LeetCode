class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int middle = left + (right - left) / 2;
            if (nums[middle] > nums[right])
                left = middle + 1;
            else if (nums[middle] < nums[right])
                right = middle;
        }
        int start = left;
        left = 0;
        right = nums.length - 1;
        if (target >= nums[start] && target <= nums[right])
            left = start;
        else
            right = start;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if (nums[middle] == target)
                return middle;
            else if (nums[middle] > target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }
}



// single pass - ref :- https://www.youtube.com/watch?v=oTfPJKGEHcc&t=324s
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            // there will be atleast one increasing part
            // we check whetehr our target reside in it
            if (nums[middle] == target) {
                return middle;
            }
            // our increasing sequence is in the left part and check whether target reside there
            else if (nums[middle] >= nums[low]) {
                if (nums[low] <= target && nums[middle] >= target)
                    high = middle - 1;
                else
                    low = middle + 1;
            }
            // out increasing sequence is in the right part and check whether the target reside there
            else if (nums[middle] < nums[low]) {
                if (nums[middle] <= target && nums[high] >= target)
                    low = middle + 1;
                else
                    high = middle - 1;
            }
        }
        return -1;
    }
}
