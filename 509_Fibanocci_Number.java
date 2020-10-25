class Solution {
    public int fib(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        int first = 0;
        int second = 1;
        int third = 0;
        int i = 2;
        while (i <= N) {
            third = first + second;
            first = second;
            second = third;
            i += 1;
        }
        return third;
    }
}
