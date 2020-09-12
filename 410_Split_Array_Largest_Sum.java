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
