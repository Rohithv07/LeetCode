class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // sort as 
        // if widths are equal, sort based on the decreeasing height
        // else carry on with width on increasing
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        // now just find the longest increasing subsequence of height and thats the answer
        // it is a general dp question and that concept can be applied here
        int length = envelopes.length;
        int [] dp = new int [length];
        /* This commented part can also be used instead of the binary search part given below
        Arrays.fill(dp, 1); // this is the minimum possible value
        for (int i=0; i<length; i++) {
            for (int j=0; j<i; j++) {
                if (envelopes[i][1] > envelopes[j][1] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int number : dp) {
            max = Math.max(number, max);
        }
        return max;
        */
        // since we sorted we can also use binary search concept for LIS
        int result = 0;
        for (int [] e : envelopes) {
            int index = Arrays.binarySearch(dp, 0, result, e[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = e[1];
            if (index == result)
                result += 1;
        }
        return result;
    }
}
