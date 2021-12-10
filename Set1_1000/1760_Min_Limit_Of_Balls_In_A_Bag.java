// same as allocate pages, aggressive cow video as reference :

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        if (nums == null || nums.length == 0 || maxOperations < 0) {
            return -1;
        }
        int low = 1;
        int high = findMax(nums);
        return binarySearch(nums, low, high, maxOperations);
    }
    
    public int binarySearch(int [] nums, int low, int high, int maxOperations) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (canDivide(nums, middle, maxOperations)) {
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return low;
    }
    
    public boolean canDivide(int [] nums, int barrier, int maxOperations) {
        int count = 0;
        for (int number : nums) {
            count += (number - 1) / barrier;
            if (count > maxOperations) {
                return false;
            }
        }
        return true;
    }
    
    public int findMax(int [] nums) {
        int max = -1;
        for (int number : nums) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}



class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = (int)1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int n : nums) {
                count = count + (n - 1) / mid;
            }
            if (count > maxOperations) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}

// https://www.youtube.com/watch?v=5ET1d6PfbNU
