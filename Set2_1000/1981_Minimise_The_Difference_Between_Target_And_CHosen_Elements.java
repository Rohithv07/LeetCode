class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        if (mat == null || mat.length == 0 || target < 0)
            return -1;
        int row = mat.length;
        int col = mat[0].length;
        // 70 * 70
        // [index][available sum]
        Integer [][] memo = new Integer [row][70 * 70 + 1];
        return minimumPossible(mat, target, 0, 0, memo);
    }
    
    public int minimumPossible(int [][] mat, int target, int currentRowIndex, int currentSum, Integer [][] memo) {
        if (currentRowIndex == mat.length) {
            return Math.abs(currentSum - target);
        }
        if (memo[currentRowIndex][currentSum] != null) {
            return memo[currentRowIndex][currentSum];
        } 
        int eachRowResult = Integer.MAX_VALUE;
        for (int colIndex = 0; colIndex < mat[0].length; colIndex++) {
            eachRowResult = Math.min(eachRowResult, minimumPossible(mat, target, currentRowIndex + 1, currentSum + mat[currentRowIndex][colIndex], memo));
        }
        return memo[currentRowIndex][currentSum] = eachRowResult;
    }
}