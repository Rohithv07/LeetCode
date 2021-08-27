class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int result = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            result++;
        }
        return left << result;
    }
}

// https://www.youtube.com/watch?v=-qrpJykY2gE&list=PLEJXowNB4kPwCPVjDv6KsAsThtDOCQUok&index=23
