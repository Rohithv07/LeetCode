class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> matrix = new ArrayList<>();
        int column = colsum.length;
        List<Integer> rowUpper = new ArrayList<>();
        List<Integer> rowLower = new ArrayList<>();
        int difference = upper - lower;
        int sum = 0; // sum of upper and lower must be equal to to colsum
        for (int number : colsum) {
            sum += number;
            if (number % 2 == 0) {
                rowUpper.add(number/2);
                rowLower.add(number/2);
            }
            else if (number == 1 && difference >= 0) {
                rowUpper.add(number);
                rowLower.add(0);
                difference -= 1;
            }
            else if (number == 1 && difference < 0) {
                rowLower.add(number);
                rowUpper.add(0);
                difference += 1;
            }
        }
        if (difference != 0 || sum != upper + lower)
            return matrix;
        matrix.add(rowUpper);
        matrix.add(rowLower);
        return matrix;
    }
}



class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> matrix = new ArrayList<>();
        int column = colsum.length;
        int [][] res = new int [2][column];
        for (int i=0; i<column; i++) {
            res[0][i] = colsum[i] == 2 || (colsum[i] == 1 && lower < upper) ? 1 : 0;
            res[1][i] = colsum[i] == 2 || (colsum[i] == 1 && res[0][i] == 0) ? 1 : 0;
            upper -= res[0][i];
            lower -= res[1][i];
        }
        return lower == 0 && upper == 0  ? new ArrayList(Arrays.asList(res[0], res[1])) : 
        new ArrayList<>();
        
    }
}