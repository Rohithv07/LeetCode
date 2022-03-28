// https://www.youtube.com/watch?v=A98psR_mIMQ

class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        // 11 22 33 44 55
        // 101 111 121 131 141
        // 1001 1111 1221 1331 1441
        // 10001 10101 10201 ....... we can observe the pattern that its liek 1, 2, 3, 4 or 10, 11, 12, 13 or 100, 101, 102 etc
        List<String> store = new ArrayList<>();
        int powerFactor = 0;
        boolean isEven = false;
        if (intLength % 2 == 0) {
            powerFactor = (int)(Math.pow(10, (intLength / 2) - 1));
            isEven = true;
        }
        else {
            powerFactor = (int)(Math.pow(10, intLength / 2));
        }
        for (int query : queries) {
            StringBuilder sb = new StringBuilder();
            int kthPalindromeStart = powerFactor + query - 1;
            sb.append(kthPalindromeStart);
            String normal = sb.toString();
            String reversed = sb.reverse().toString();
            sb = new StringBuilder();
            if (isEven) {
                // 100 -> we reverse fully to get 001 and append both to get 100001
                sb.append(normal).append(reversed);
            }
            else {
                //100 -> we reverse the first 2 letters to get 01 and append both to get 10001
                sb.append(normal).append(reversed.substring(1));
            }
            if (sb.length() == intLength)
                store.add(sb.toString());
            else
                store.add("-1");
        }
        //System.out.println
        long [] result = new long [store.size()];
        int index = 0;
        for (String value : store) {
            result[index++] = Long.valueOf(value);
        }
        return result;
    }
}