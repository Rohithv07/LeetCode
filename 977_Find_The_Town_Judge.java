// in-degree - out-degree = N - 1 become the judge.

class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] degree = new int [n + 1];
        for (int [] t : trust) {
            degree[t[0]] -= 1; // indegree
            degree[t[1]] += 1; // outdegree
        }
        for (int i=1; i<=n; i++) {
            //System.out.println(degree[i]);
            if (degree[i] == n - 1)
                return i;
        }
        return -1;
    }
}
