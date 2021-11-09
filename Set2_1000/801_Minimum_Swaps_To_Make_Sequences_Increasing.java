/*
A[i - 1] < A[i] && B[i - 1] < B[i].
In this case, if we want to keep A and B increasing before the index i, can only have two choices.
-> 1.1 don't swap at (i-1) and don't swap at i, we can get not_swap[i] = not_swap[i-1]
-> 1.2 swap at (i-1) and swap at i, we can get swap[i] = swap[i-1]+1
if swap at (i-1) and do not swap at i, we can not guarantee A and B increasing.

A[i-1] < B[i] && B[i-1] < A[i]
In this case, if we want to keep A and B increasing before the index i, can only have two choices.
-> 2.1 swap at (i-1) and do not swap at i, we can get notswap[i] = Math.min(swap[i-1], notswap[i] )
-> 2.2 do not swap at (i-1) and swap at i, we can get swap[i]=Math.min(notswap[i-1]+1, swap[i])

*/



class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return -1;
        }
        if (nums1.length != nums2.length) {
            return -1;
        }
        int n = nums1.length;
        int [] swap = new int [n];
        int [] keep = new int [n];
        Arrays.fill(swap, Integer.MAX_VALUE);
        Arrays.fill(keep, Integer.MAX_VALUE);
        swap[0] = 1;
        keep[0] = 0;
        for (int i=1; i<n; i++) {
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                swap[i] = swap[i - 1] + 1;
                keep[i] = keep[i - 1];
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                swap[i] = Math.min(swap[i], keep[i - 1] + 1);
                keep[i] = Math.min(keep[i], swap[i - 1]);
            }
        }
        return Math.min(swap[n - 1], keep[n - 1]);
    }
}