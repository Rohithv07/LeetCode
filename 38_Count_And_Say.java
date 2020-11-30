class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String answer = "1";
        for (int i=2; i<=n; i++) {
            answer = helper(answer);
        }
        return answer;
    }
    public String helper(String s) {
        char ch = s.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) != ch) {
                sb.append(count).append(ch);
                ch = s.charAt(i);
                count = 1;
            }
            else
                count += 1;
        }
        sb.append(count).append(ch);
        return sb.toString();
    }
}
