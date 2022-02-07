class Solution {
    public long smallestNumber(long num) {
        if (num == 0) {
            return 0;
        }
        boolean isNegative = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        long temp = num;
        while (num > 0) {
            sb.append(num % 10);
            num /= 10;
        }
        char [] array = sb.toString().toCharArray();
        Arrays.sort(array);
        sb = new StringBuilder();
        if (isNegative) {
            sb.append(array[array.length - 1]);
            for (int i = array.length - 2; i >= 0; i--) {
                sb.append(array[i]);
            }
        }
        else {
            int i = 0;
            if (array[0] == '0') {
                while (array[i] == '0') {
                    i += 1;
                }
                int firstIndex = i;
                sb.append(array[i]);
                i = 0;
                for (i = 0; i < array.length; i++) {
                    if (i != firstIndex) {
                        sb.append(array[i]);
                    }
                }
            }
            else {
                i = 0;
                for (i = 0; i < array.length; i++) {
                    sb.append(array[i]);
                }
            }
        }
        String finalResult = sb.toString();
        return isNegative ? -1 * Long.valueOf(finalResult) : Long.valueOf(finalResult);
    }
}