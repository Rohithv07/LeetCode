class Solution {
    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int maxLength = 0;
        int length = nums.length;
        int countZero = 0;
        for (int i=0; i<length; i++) {
            if (nums[i] == 0) {
                countZero += 1;
            }
            while (countZero > k) {
                if (nums[low] == 0)
                    countZero -= 1;
                low += 1;
            }
            maxLength = Math.max(maxLength, i - low + 1);
        }
        return maxLength;
    }
}

class Solution {
    public int longestOnes(int[] A, int k) {
        int start = 0;
        int end;
        for (end=0; end<A.length; end++) {
            if (A[end] == 0)
                k -= 1;
            if (k<0 && A[start++] == 0)
                k += 1;
        }
        return end - start;
    }
}
