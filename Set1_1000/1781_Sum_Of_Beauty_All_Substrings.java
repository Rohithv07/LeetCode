class Solution {
    public int beautySum(String s) {
        int result = 0;
        int [] sum = new int [26];
        for (int i=0; i<s.length(); i++) {
            sum[s.charAt(i) - 'a'] ++;
            result += helper(sum);
        }
        if (s.length() > 1)
            result += beautySum(s.substring(1));
        return result;
    }
    
    public int helper(int [] sum) {
        int max  = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<26; i++) {
            max = Math.max(max, sum[i]);
            min = sum[i] != 0 ? Math.min(min, sum[i]) : min;
        }
        return max - min;
    }
}
