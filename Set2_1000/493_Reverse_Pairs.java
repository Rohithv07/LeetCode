// https://youtu.be/S6rsAlj_iB4 reference
class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int length = nums.length;
        int [] temp = new int [length];
        return mergeSortAndCount(nums, temp, 0, length - 1);
    }
    
    public int mergeSortAndCount(int [] nums, int [] temp, int left, int right) {
        int count = 0;
        if (left < right) {
            int middle = left + (right - left) / 2;
            count += mergeSortAndCount(nums, temp, left, middle);
            count += mergeSortAndCount(nums, temp, middle + 1, right);
            count += merge(nums, temp, left, right, middle + 1);
        }
        return count;
    }
    
    public int merge(int [] nums, int [] temp, int left, int right, int middle) {
        int count = 0;
        int j = middle;
        for (int i=left; i<middle; i++) {
            while (j <= right && nums[i] > 2 * (long)nums[j]) {
                j++;
            }
            count += (j - middle);
        }
        int i = left;
        j = middle;
        int k = left;
        while (i < middle && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            }
            else {
                temp[k++] = nums[j++];
            }
        }
        while (i < middle) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int p=left; p<=right; p++) {
            nums[p] = temp[p];
        }
        return count;
    }
    
    
}