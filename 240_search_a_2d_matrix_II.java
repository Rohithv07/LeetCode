class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // always brute force first O(row*col)
        int row = matrix.length;
        if (row == 0)
            return false;
        int col = matrix[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
        
        // since the given matrix is sorted, we can always makes search on a sorted items we can do binary search
        /*
        We start search the matrix from top right corner, initialize the current position to top right corner, if the target is     greater than the value in current position, then the target can not be in entire row of current position because the row is     sorted, if the target is less than the value in current position, then the target can not in the entire column because the          column is sorted too. We can rule out one row or one column each time, so the time complexity is O(row+col).
        */
        int row = 0;
        if (matrix.length == 0)
            return false;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] < target)
                row += 1;
            else col -= 1;
        }
        return false;
    }
}
