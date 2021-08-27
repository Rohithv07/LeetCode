class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<>();
        
        if(matrix.length == 0 || matrix[0].length == 0)
            return output;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        
        
        
        int low_row = 0, high_row = m-1, low_col = 0, high_col = n-1, i;
        while(low_row <= high_row && low_col <= high_col){
            for(i = low_row; i <= high_col; i++)
                output.add(matrix[low_row][i]);
            
            low_row++;
            for(i = low_row; i <= high_row; i++)
                output.add(matrix[i][high_col]);
            
            high_col--;
            if(low_row <= high_row){
                for(i = high_col; i >= low_col; i--)
                    output.add(matrix[high_row][i]);
                high_row--;
            }
            if(low_col <= high_col){
                for(i = high_row; i >= low_row; i--)
                    output.add(matrix[i][low_col]);
                low_col++;
            }
        }
        return output;
    }
}
