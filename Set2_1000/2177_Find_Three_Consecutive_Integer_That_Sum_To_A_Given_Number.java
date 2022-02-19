class Solution {
    public long[] sumOfThree(long num) {
        long firstNumber = (num - 3) / 3;
        if ((firstNumber * 3) + 3 == num) {
            return new long []{firstNumber, firstNumber + 1, firstNumber + 2};
        }
        return new long[]{};
    }
}