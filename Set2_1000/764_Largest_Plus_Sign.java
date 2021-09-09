// Using single 2d array ref : https://leetcode.com/problems/largest-plus-sign/discuss/146531/java-simple-DP-solution-using-one-matrix-easy-to-undersatnd

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int [][] grid = new int [n][n];
        for (int [] g : grid) {
            Arrays.fill(g, 1);
        }
        for (int [] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        int answer = 0;
        if (mines.length < n * n)
            answer = 1;
        int [][] leftPart = new int [n][n];
        int [][] rightPart = new int [n][n];
        int [][] topPart = new int [n][n];
        int [][] bottomPart = new int [n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    leftPart[i][j] = 0;
                    topPart[i][j] = 0;
                }
                else {
                    leftPart[i][j] = (j - 1 >= 0) ? leftPart[i][j - 1] + 1 : 1;
                    topPart[i][j] = (i - 1 >= 0) ? topPart[i - 1][j] + 1 : 1;
                }
            }
        }
        for (int i=n-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (grid[i][j] == 0) {
                    rightPart[i][j] = 0;
                    bottomPart[i][j] = 0;
                }
                else {
                    rightPart[i][j] = (j + 1 < n) ? rightPart[i][j + 1] + 1 : 1;
                    bottomPart[i][j] = (i + 1 < n) ? bottomPart[i + 1][j] + 1 : 1;
                }
                answer = Math.max(answer, Math.min(Math.min(leftPart[i][j], bottomPart[i][j]), Math.min(rightPart[i][j], topPart[i][j])));
            }
        }
        return answer;
    }
}



// only single array


class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int [][] grid = new int [n][n];
        for (int [] g : grid) {
            Arrays.fill(g, 1);
        }
        for (int [] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        int answer = 0;
        if (mines.length < n * n)
            answer = 1;
        int count = 0;
        for (int i=0; i<n; i++) {
            count = 0;
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    count = 0;
                }
                else {
                    count++;
                }
                grid[i][j] = count;
            }
            count = 0;
            for (int j=n-1; j>=0; j--) {
                if (grid[i][j] == 0) {
                    count = 0;
                }
                else {
                    count ++;
                }
                grid[i][j] = Math.min(grid[i][j], count);
            }
        }
        for (int j=0; j<n; j++) {
            count = 0;
            for (int i=0; i<n; i++) {
                if (grid[i][j] == 0) {
                    count = 0;
                }
                else {
                    count++;
                }
                grid[i][j] = Math.min(grid[i][j], count);
            }
            count = 0;
            for (int i=n-1; i>=0; i--) {
                if (grid[i][j] == 0) {
                    count = 0;
                }
                else {
                    count++;
                }
                grid[i][j] = Math.min(grid[i][j], count);
                answer = Math.max(answer, grid[i][j]);
            }
        }
        return answer;
    }
}