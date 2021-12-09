// ref video : see allocate pages in youtube and the same method is followed.

class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m < 0) {
            return -1;
        }
        int low = findMax(nums);
        int high = totalSum(nums);
        return binarySearch(nums, m, low, high);
    }
    
    public int binarySearch(int [] nums, int m, int low, int high) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (isPossibleToHaveMWithinMiddle(nums, m, middle)) {
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return low;
    }
    
    public boolean isPossibleToHaveMWithinMiddle(int [] nums, int m, int barrier) {
        int currentSubArraySum = 0;
        int subArrayCount = 1;
        for (int number : nums) {
            currentSubArraySum += number;
            if (currentSubArraySum > barrier) {
                subArrayCount += 1;
                currentSubArraySum = number;
            }
            if (subArrayCount > m) {
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
    
    public int totalSum(int [] nums) {
        int sum = 0;
        for (int number : nums) {
            sum += number;
        }
        return sum;
    }
}








class Solution {
    public int splitArray(int[] nums, int m) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = total(nums);
        while (left < right) {
            int middle = left + (right-left) / 2;
            if (isLargestSum(middle, nums, m))
                right = middle;
            else
                left = middle + 1;
        }
        return left;
        
    }
    public boolean isLargestSum(int middle, int [] nums, int m) {
        int split = 1;
        int largest = 0;
        for (int num: nums) {
            largest += num;
            if (largest > middle) {
                largest = num;
                split += 1;
                if (split > m) 
                    return false;
            }
        }
        return true;
    }
    public int total(int [] array) {
        int totalSum = 0;
        for (int n: array)
            totalSum += n;
        return totalSum;
    }
    
    }
