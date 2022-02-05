class Solution {
    public int minimumSum(int num) {
        if (num < 10) {
            return num;
        }
        int minSum = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        int temp = num;
        while (temp > 0) {
            int rem = temp % 10;
            sb.append(rem);
            temp /= 10;
        }
        String key = sb.reverse().toString();
        char [] converted = key.toCharArray();
        Arrays.sort(converted);
        return ((converted[0] - '0') * 10 + converted[3] -'0') + ((converted[1] - '0') * 10 + converted[2] - '0');
        
    }
}

// actually there is no need to convert to character array