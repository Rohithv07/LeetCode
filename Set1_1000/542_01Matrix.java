class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == 0)
                    queue.add(new int []{i, j});
                else
                    matrix[i][j] = Integer.MAX_VALUE; // to mark it as not visited
            }
        }
        int [][] directions = new int [][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int [] dir : directions) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                if (newX < 0 || newY < 0 || newX >= row || newY >= col || matrix[newX][newY] <= matrix[x][y] + 1)
                    continue;
                queue.add(new int [] {newX, newY});
                matrix[newX][newY] = matrix[x][y] + 1;
            }
        }
        return matrix;
    }
}


// dp

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0)
            return new int [][]{};
        int row = mat.length;
        int col = mat[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (mat[i][j] == 1) {
                    if (i > 0 && j > 0) {
                        mat[i][j] = Math.min(mat[i - 1][j], mat[i][j - 1]) + 1;
                    }
                    else if (i > 0) {
                        mat[i][j] = mat[i - 1][j] + 1;
                    }
                    else if (j > 0) {
                        mat[i][j] = mat[i][j - 1] + 1;
                    }
                    else {
                        mat[i][j] = row + col;
                    }
                }
            }
        }
        for (int i=row-1; i>=0; i--) {
            for (int j=col-1; j>=0; j--) {
                if (mat[i][j] > 1) {
                    if (i < row - 1) {
                        mat[i][j] = Math.min(mat[i][j], mat[i + 1][j] + 1);
                    }
                    if (j < col - 1) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][j + 1] + 1);
                    }
                }
            }
        }
        return mat;
    }
}
