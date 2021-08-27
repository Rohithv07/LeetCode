class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int number: A)
            sum += number;
        int average = sum / 3;
        int count = 0;
        int part = 0;
        for (int number: A) {
            part += number;
            if (part == average) {
                part = 0;
                count ++;
            }
        }
        return count >= 3 && sum % 3 == 0;
    }
}
