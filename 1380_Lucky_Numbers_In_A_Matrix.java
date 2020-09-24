/* 
My thought process

Here we can find the minimum value from each row and store it in an array, same way we can find the maximum value from each column. After forming these arrays, lets look at the question itself, whats a Lucky number
        "A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column."
        
So that particular number will be smallest in rows and largest in columns, so it will be present in both the minRow array and maxCol array. And we can find these numbers then add them to list and finally return this list and we get our answer.
*/


class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int [] minRowVal = new int [row];
        int [] maxColVal = new int [col];
        Arrays.fill(minRowVal, Integer.MAX_VALUE);
        Arrays.fill(maxColVal, Integer.MIN_VALUE);
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                minRowVal[i] = Math.min(minRowVal[i], matrix[i][j]);
                maxColVal[j] = Math.max(maxColVal[j], matrix[i][j]);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (minRowVal[i] == maxColVal[j])
                    result.add(minRowVal[i]);
            }
        }
        return result;
    }
}
