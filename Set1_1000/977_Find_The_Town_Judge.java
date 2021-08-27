class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] trusting = new int [n + 1];
        int [] trustedBy = new int [n + 1];
        for (int [] t : trust) {
            trusting[t[0]] += 1;
            trustedBy[t[1]] += 1;
        }
        // for judge trustedBY == n-1 and trusting = 0 as judge didnt trust anybody
        for (int i=1; i<=n; i++) {
            if (trustedBy[i] == n - 1 && trusting[i] == 0)
                return i;
        }
        return -1;
    }
}


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
