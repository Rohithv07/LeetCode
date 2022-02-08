// https://www.youtube.com/watch?v=k2iS5t78N4Q
class Solution {
    public int minimumTime(String s) {
        // total length + count of 1 in middle - count of 0 in middle
        // we need count of 0 as large as possible to minimise the result
        // so if we consider all the 0s as -1, then we just need to find smallest subarray sum
        // result is length + smallest subarray sum
        int length = s.length();
        int result = length;
        int [] sArray = new int [length];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sArray[i] = -1;
            }
            else {
                sArray[i] = 1;
            }
        }
        int minimumSum = 0;
        int currentSum = 0;
        for (int number : sArray) {
            currentSum += number;
            minimumSum = Math.min(minimumSum, currentSum);
            // reverse of Kadane
            if (currentSum > 0) {
                currentSum = 0;
            }
        }
        return length + minimumSum;
    }
}