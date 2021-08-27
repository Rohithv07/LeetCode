class Solution {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0)
            return -1;
        int length = 1;
        int currentNumber = 1;
        while (currentNumber % K != 0) {
            currentNumber = (currentNumber % K) * 10 + 1;
            length += 1;
        }
        return length;
    }
}
