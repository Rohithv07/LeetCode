// https://www.youtube.com/watch?v=IShCyNmsoL8

class Solution {
    int sum = 0;
    public int numberOfArithmeticSlices(int[] A) {
        // 1. Recursion Approach
        int length = A.length;
        dfs(A, length - 1);
        return sum;
    }
    
    public int dfs(int [] A, int i) {
        if (i < 2)
            return 0;
        int result = 0;
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
            result = 1 + dfs(A, i-1);
            sum += result;
        }
        else {
            dfs(A, i - 1);
        }
        return result;
        
        // 2. dynamic programming
        int dp = 0;
        int sum = 0;
        int length = A.length;
        for (int i=length - 1; i>=2; i--) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp += 1;
                sum += dp;
            }
            else {
                dp = 0;
            }
        }
        return sum;
    }
}
