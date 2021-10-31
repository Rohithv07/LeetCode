class Solution {
    public int lengthOfLIS(int[] array) {
        int [] LIS = new int [array.length];
        int max=0;
        for (int i=0; i<array.length; i++) {
            LIS[i] = 1;
        }
        for (int i=1; i<array.length; i++) {
            for (int j=0; j<i; j++) {
                if (array[i] > array[j] && LIS[i] < LIS[j] + 1)
                    LIS[i] = LIS[j] + 1;
            }
        }
        for (int i=0; i<LIS.length; i++) {
            if (max < LIS[i])
                max = LIS[i];
        }
        return max;
    }
}

// binary search simple form
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int [] dp = new int [length];
        int maxLength = 0;
        for (int number : nums) {
            int left = 0;
            int right = maxLength;
            while (left != right) {
                int middle = left + (right - left) / 2;
                if (dp[middle] < number) {
                    left = middle + 1;
                }
                else {
                    right = middle;
                }
            }
            dp[left] = number;
            if (left == maxLength) {
                maxLength++;
            }
        }
        return maxLength;
    }
}


class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int [] dp = new int [length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i=1; i<length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        for (int number : dp) {
            max = Math.max(max, number);
        }
        return max;
        
        // binary search
        int n = nums.length;
        int length = 0;
        int [] dp = new int [n];
        for (int number : nums) {
            int index = Arrays.binarySearch(dp, 0, length, number);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = number;
            if (index == length)
                length += 1;
        }
        return length;
    }
}