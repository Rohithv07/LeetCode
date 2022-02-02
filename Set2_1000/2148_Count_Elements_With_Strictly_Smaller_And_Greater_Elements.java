// approach 1

class Solution {
    public int countElements(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int smaller = nums[0];
        int larger = nums[length - 1];
        if (larger == smaller) {
            return 0;
        }
        int count = 0;
        int countMax = 0;
        int countMin = 0;
        for (int i=0; i<length; i++) {
            if (nums[i] == smaller) {
                countMin++;
            }
            else {
                break;
            }
        }
        for (int i=length-1; i>=0; i--) {
            if (nums[i] == larger) {
                countMax++;
            }
            else {
                break;
            }
        }
        return length - countMax - countMin;
    }
}

// similar approach but just finding smaller and larger without sorting

class Solution {
    public int countElements(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int length = nums.length;
        int max = nums[0];
        int min = nums[0];
        int count = 0;
        for (int i=1; i<length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        for (int i=0; i<length; i++) {
            if (nums[i] > min && nums[i] < max) {
                count++;
            }
        }
        return count;
    }
}