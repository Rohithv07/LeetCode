class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currentColor = image[sr][sc];
        if (currentColor != newColor) {
            dfs(image, sr, sc, currentColor, newColor);
        }
        return image;
    }
    
    public void dfs(int [][] image, int i, int j, int color, int newColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != color)
            return;
        image[i][j] = newColor;
        dfs(image, i+1, j, color, newColor);
        dfs(image, i-1, j, color, newColor);
        dfs(image, i, j-1, color, newColor);
        dfs(image, i, j+1, color, newColor);
    }
}
