class Solution {
    public boolean isSameAfterReversals(int num) {
        if (num < 10) {
            return true;
        }
        return num % 10 != 0;
    }
}