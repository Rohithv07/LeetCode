class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n= arr.length;
        int left = 0;
        int right = n - 1;
        while (left < n-1 && arr[left+1] >= arr[left])
            left ++;
        if (left == n - 1)
            return 0;
        while (right > 0 && arr[right-1] <= arr[right])
            right --;
        int canBeRemoved = Math.min(n-1-left, right);
        int i = 0;
        int j = right;
        while (i <= left && j < n) {
            if (arr[j] >= arr[i]) {
                canBeRemoved = Math.min(canBeRemoved, j-1-i);
                i ++;
            }
            else 
                j ++;
        }
        return canBeRemoved;
    }
}
