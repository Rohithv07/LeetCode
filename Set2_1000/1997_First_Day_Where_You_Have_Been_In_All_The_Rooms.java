// to reach ith room you have to go through i - 1 room
// so atleast dp[i - 1] days will be required
// room i - 1 will send us back to next(i - 1), so we also need dp[i - 1] - dp[next[i - 1]] + 2 days


class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        if (nextVisit == null || nextVisit.length == 0) {
            return -1;
        }
        int length = nextVisit.length;
        long [] dp = new long [length];
        int mod = (int)1e9 + 7;
        for (int i=1; i<length; i++) {
            dp[i] = (2 * dp[i - 1] - dp[nextVisit[i - 1]] + 2 + mod) % mod;
        }
        return (int)(dp[length - 1] % mod);
        
    }
}