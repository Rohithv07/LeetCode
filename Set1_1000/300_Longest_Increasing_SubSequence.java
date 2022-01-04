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


// idea behind the binary search with an example

/*
Let's construct the idea from following example.

Consider the example nums = [2, 6, 8, 3, 4, 5, 1], let's try to build the increasing subsequences starting with an empty one: sub1 = [].

Let pick the first element, sub1 = [2].
6 is greater than previous number, sub1 = [2, 6]
8 is greater than previous number, sub1 = [2, 6, 8]
3 is less than previous number, we can't extend the subsequence sub1, but we must keep 3 because in the future there may have the longest subsequence start with [2, 3], sub1 = [2, 6, 8], sub2 = [2, 3].
With 4, we can't extend sub1, but we can extend sub2, so sub1 = [2, 6, 8], sub2 = [2, 3, 4].
With 5, we can't extend sub1, but we can extend sub2, so sub1 = [2, 6, 8], sub2 = [2, 3, 4, 5].
With 1, we can't extend neighter sub1 nor sub2, but we need to keep 1, so sub1 = [2, 6, 8], sub2 = [2, 3, 4, 5], sub3 = [1].
Finally, length of longest increase subsequence = len(sub2) = 4.

In the above steps, we need to keep different sub arrays (sub1, sub2..., subk) which causes poor performance. 
But we notice that we can just keep one sub array, when new number x is not greater than the last element of the subsequence sub, 
we do binary search to find the smallest element >= x in sub, and replace with number x.

Let's run that example nums = [2, 6, 8, 3, 4, 5, 1] again:
Let pick the first element, sub = [2].
6 is greater than previous number, sub = [2, 6]
8 is greater than previous number, sub = [2, 6, 8]
3 is less than previous number, so we can't extend the subsequence sub. We need to find the smallest number >= 3 in sub, it's 6. Then we overwrite it, now sub = [2, 3, 8].
4 is less than previous number, so we can't extend the subsequence sub. We overwrite 8 by 4, so sub = [2, 3, 4].
5 is greater than previous number, sub = [2, 3, 4, 5].
1 is less than previous number, so we can't extend the subsequence sub. We overwrite 2 by 1, so sub = [1, 3, 4, 5].
Finally, length of longest increase subsequence = len(sub) = 4.
*/



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