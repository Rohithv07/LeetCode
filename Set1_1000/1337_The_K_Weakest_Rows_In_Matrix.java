// there are only 1s and 0s
// 1s - soldiers 0s - civilians
// a row is said to be weaker based on the number of soldiers on a particular row less than the other row
// so we can go through the matrux row wise and save the count in array.
// if we see a 0, then there wont be anymore soldiers in that row as stated
// finally we can just sort the count array and return the first k as an array.
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;
        // now we need an array to store the count of 1s in each row
        int [] count = new int [row];
        int [] result = new int [k];
        // traverse through the array and take down the count
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                // 1s will be at front always and there wont be any ones after 0, so if we see a 0, then we are done with current row
                if (mat[i][j] == 0)
                    break;
                else
                    count[i] += 1;
            }
        }
        int index = 0;
        while (k > 0) {
            int minIndex = 0;
            for (int i=0; i<count.length; i++) {
                if (count[i] < count[minIndex])
                    minIndex = i;
            }
            result[index++] = minIndex;
            count[minIndex] = Integer.MAX_VALUE;
            k -= 1;
        }
        return result;
    }
}
