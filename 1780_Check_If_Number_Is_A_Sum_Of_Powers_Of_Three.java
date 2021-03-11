// n % 3 != 2

class Solution {
    public boolean checkPowersOfThree(int n) {
        if (n == 1 || n == 3)
            return true;
        while (n > 0) {
            if (n % 3 == 2)
                return false;
            n /= 3;
        }
        return true;
    }
}

// O(logn)
