class Solution {
    public int countHomogenous(String s) {
        int individualCount = 1;
        int mod = (int) 1e9 + 7;
        int result = 1;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                individualCount += 1;
            else
                individualCount = 1;
            result = (result + individualCount) % mod;
        }
        return result;
    }
}
