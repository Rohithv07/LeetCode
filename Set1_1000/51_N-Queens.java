class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // initialize our current board with '.'
        char [][] current = new char[n][n];
        for (int i=0; i<n; i++) 
            for (int j=0; j<n; j++) 
                current[i][j] = '.';
        helperFunction(result, current, n, 0);
        System.out.println(result.size());
        return result;
    }
    public void helperFunction(List<List<String>> result, char [][] current, int n, int start) {
        // 1. Our goal
        if (start == n) {
            List<String> finalAdd = new ArrayList<>();
            for (int i=0; i<current.length; i++) {
                String s = new String(current[i]);
                finalAdd.add(s);
            }
            result.add((finalAdd));
            return;
        }
        for (int i=0; i<n; i++) {
                // 2. Our choice
                if (isValid(current, i, start)) {
                    current[i][start] = 'Q';
                    // 3. Our constraint
                    helperFunction(result, current, n, start+1);
                }
                // 4. Undo our choice
                current[i][start] = '.';
        }
    }
    public boolean isValid(char [][] current, int x, int y) {
        for (int i=0; i<current.length; i++) {
            for (int j=0; j<current[i].length; j++) {
                if (current[i][j] == 'Q' && (x+j == y+i || x+y == i+j || x == i))
                    return false;
            }
        }
        return true;
    }
}
