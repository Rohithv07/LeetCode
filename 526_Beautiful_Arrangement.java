class Solution {
    public int countArrangement(int n) {
        if (n == 1)
            return 1;
        int [] count = new int [1];
        int [] visited = new int [n+1];
        backtrack(n, 1, count, visited);
        return count[0];
    }
    
    public void backtrack(int n, int position, int [] count, int [] visited) {
        if (position > n) {
            count[0] += 1;
            return;
        }
        for (int i=1; i<=n; i++) {
            if (visited[i] == 0 && (i % position == 0 || position % i == 0)) {
                visited[i] = 1;
                backtrack(n, position + 1, count, visited);
                visited[i] = 0;
            }
        }
    }
}
