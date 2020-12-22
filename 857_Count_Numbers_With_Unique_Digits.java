class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int result = 10;
        int availableNumbers = 9;
        int option = 9;
        while (n-- > 1 && availableNumbers > 0) {
            option = option * availableNumbers;
            result += option;
            availableNumbers --;
        }
        return result;
    }
}