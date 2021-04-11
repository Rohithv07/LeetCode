class Solution {
    public int arraySign(int[] nums) {
        int numberOfNegatives = 0;
        for (int number : nums) {
            if (number == 0)
                return 0;
            if (number < 0)
                numberOfNegatives += 1;
        }
        return numberOfNegatives % 2 == 0 ? 1 : -1;
    }
}


