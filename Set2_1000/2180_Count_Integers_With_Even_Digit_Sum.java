class Solution {
    public int countEven(int num) {
        int temp = num;
        int sum = 0;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum % 2 == 0 ? num / 2 : (num - 1) / 2;
    }
}