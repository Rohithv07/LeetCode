class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = (int)1e9 + 7;
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        long [] dp = new long[n];
        Arrays.fill(dp, 1);
        for (int i=0; i<n; i++) {
            map.put(arr[i], i);
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (map.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] *dp[map.get(right)]) % mod;
                    }
                }
            }
        }
        long answer = 0;
        for (long number : dp) {
            answer += number;
        }
        return (int) (answer % mod);
    }
}
