class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            int reversed = reverse(i);
            if (i + reversed == num) {
                return true;
            }
        }
        return false;
    }
    
    private int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            int rem = num % 10;
            reversed = reversed * 10 + rem;
            num /= 10;
        }
        return reversed;
    }
}