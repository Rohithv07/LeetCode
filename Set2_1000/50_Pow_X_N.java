class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double result = 1.0;
        long number = n;
        if (number < 0) {
            number *= -1;
        }
        while (number > 0) {
            if (number % 2 == 0) {
                x = x * x;
                number /= 2;
            }
            else {
                result = x * result;
                number -= 1;
            }
        }
        if (n < 0) {
            return 1.0/result;
        }
        return result;
    }
}




// using recursion
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            return (1/x) * myPow(1/x, -(n + 1));
        }
        return (n % 2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}