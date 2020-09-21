class Solution {
    public int minCost(int n, int[] cuts) {
        int [][] dp = new int[cuts.length+2][cuts.length+2];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(cuts);
        list.add(0); // here we store from to the the stick length... labelled from 0 to n
        for (int i=0; i<cuts.length; i++) {
            list.add(cuts[i]);
        }
        list.add(n);
        int size = list.size();
        for (int i=size-1; i>=0; i--) {
            for (int j=i+1; j<size; j++) {
                int distance = list.get(j) - list.get(i);
                int minimum = Integer.MAX_VALUE;
                for (int k=0; k<size; k++) {
                    int currentCut = list.get(k);
                    if (currentCut>list.get(i) && currentCut<list.get(j))
                        minimum = Math.min(minimum, dp[i][k]+dp[k][j]);
                }
                if (minimum != Integer.MAX_VALUE)
                    dp[i][j] = minimum + distance;
            }
        }
        return dp[0][cuts.length+1];
    }
}
