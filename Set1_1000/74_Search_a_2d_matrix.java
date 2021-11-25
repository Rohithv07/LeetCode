class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // lets start by brute force
        if (matrix.length == 0)
            return false;
        int row = matrix.length; 
        int col = matrix[0].length;
        // since it is sorted the maximum will be in the last row last col and the min element will be in the first row first col
        if (target > matrix[row-1][col-1] || target < matrix[0][0])
            return false;
        // O(mn)
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
        
        
        // since its searching in a matrix, we can make use of binary search.
        if (matrix.length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid/col][mid%col] == target)
                return true;
            else if (matrix[mid/col][mid%col] < target)
                left = mid + 1;
            else 
                right = mid - 1;
        }
        return false;
        // O(log(row) + log(col))
    }
}


// another way of doing (not binary search)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int low = row - 1;
        int high = 0;
        while (low >= 0 && high < col) {
            if (matrix[low][high] == target) {
                return true;
            }
            else if (matrix[low][high] > target) {
                low--;
            }
            else {
                high++;
            }
        }
        return false;
    }
}

