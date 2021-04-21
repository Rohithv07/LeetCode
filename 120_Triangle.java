class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 0)
            return 0;
        int [] dp = new int [size + 1];
        for (int i=size - 1; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                int currentValue = triangle.get(i).get(j);
                dp[j] = Math.min(dp[j], dp[j + 1]) + currentValue;
            }
        }
        return dp[0];
    }
}

// ref : https://www.youtube.com/watch?v=hM4mHTi4AnA
