/*https://www.youtube.com/watch?v=dAVF2NpC3j4*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0)
            return 0;
        int col = matrix[0].length;
        int max = 0;
        int [][] dp = new int [row][col];
        // calculate the height
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                }
                else {
                    if (matrix[i][j] == '1')
                        dp[i][j] = dp[i - 1][j] + matrix[i][j] - '0';
                }
            }
        }
        for (int [] eachRow : dp) {
            max = Math.max(max, largestRectangleHistogram(eachRow));
        }
        return max;
    }
    
    // same code for largest rectangle in a histogram
    public int largestRectangleHistogram(int [] h) {
        if (h == null || h.length == 0)
            return 0;
        int length = h.length;
        int [] left = new int [length];
        int [] right = new int [length];
        int max = 0;
        left[0] = -1;
        right[length - 1] = length;
        for (int i=1; i<length; i++) {
            int currentIndex = i - 1;
            while (currentIndex >= 0 && h[currentIndex] >= h[i]) {
                currentIndex = left[currentIndex];
            }
            left[i] = currentIndex;
        }
        for (int i=length - 2; i>=0; i--) {
            int currentIndex = i + 1;
            while (currentIndex < length && h[currentIndex] >= h[i]) {
                currentIndex = right[currentIndex];
            }
            right[i] = currentIndex;
        }
        for (int i=0; i<length; i++) {
            max = Math.max(max, h[i] * (right[i] - left[i] - 1));
        }
        return max;
    }
}
