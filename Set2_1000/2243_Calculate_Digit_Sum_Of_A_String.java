class Solution {
    public String digitSum(String s, int k) {
        int length = s.length();
        if (length <= k) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > k) {
            int rem = sb.length() % k;
            String current = sb.toString();
            int currentLength = current.length();
            sb = new StringBuilder();
            for (int i = 0; i < currentLength - rem;) {
                String set = current.substring(i, i + k);
                i += k;
                int sum = findSum(set);
                sb.append(sum);
            }
            if (rem != 0) {
                String remainder = current.substring(currentLength - rem);
                int sum = findSum(remainder);
                sb.append(sum);
            }
        }
        return sb.toString();
    }
    
    public int findSum(String s) {
        int sum = 0;
        for (char ch : s.toCharArray()) {
            sum += (ch - '0');
        }
        return sum;
    }
}