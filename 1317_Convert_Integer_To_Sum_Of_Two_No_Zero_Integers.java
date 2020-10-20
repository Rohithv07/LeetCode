// this can be simply done by iterating from 1 to n, take the ith and n-i value. Check if both the values are having zero, if not take these 2 numbers as the valid answer and save it, otherwise continue with the other one

class Solution {
    public int[] getNoZeroIntegers(int n) {
        if (n == 2)
            return new int [] {1, 1};
        int [] result = new int [2];
        for (int i=1; i<=n; i++) {  //O(n)
            int firstNumber = i;
            int secondNumber = n - i;
            if (isNoZero(firstNumber) && isNoZero(secondNumber)) { //O(i/10 * (n-i)/10)
                result[0] = firstNumber;
                result[1] = secondNumber;
                break;
            }
        }
        return result;
    }
    public boolean isNoZero(int n) {
        while (n > 0) { 
            int rem = n % 10;
            if (rem == 0)
                return false;
            n = n / 10;
        }
        return true;
    }
}
