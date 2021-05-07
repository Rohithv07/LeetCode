class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        boolean [][] graph = new boolean[N][N];
        for (int [] d : dislikes) {
            graph[d[0] - 1][d[1] - 1] = true;
            graph[d[1] - 1][d[0] - 1] = true;
        }
        int [] colour = new int [N];
        for (int i=0; i<N; i++) {
            if (colour[i] == 0 && !dfsHelper(i, 1, colour, graph))
                return false;
        }
        return true;
    }
    
    public boolean dfsHelper(int index, int c, int [] colour, boolean [][] graph) {
        if (colour[index] != 0)
            return colour[index] == c;
        colour[index] = c;
        for (int i=0; i<colour.length; i++) {
            if (graph[index][i] && !dfsHelper(i, -c, colour, graph))
                return false;
        }
        return true;
    }
}
