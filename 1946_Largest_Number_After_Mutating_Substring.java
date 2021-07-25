// the change must be continuos, ie substring
// we cannot change everywhere when we find the current digit is smaller than that in the array
// only the elemnets that are continuous must be changed
// so when we start changing, just point out that we started the mutation with the help of boolean variable


class Solution {
    public String maximumNumber(String num, int[] change) {
        if (num == null || num.length() == 0)
            return "";
        if (change == null || change.length == 0)
            return num;
        int lengthString = num.length();
        int lengthChange = change.length;
        boolean isWeStartedMutating = false;
        char [] convertedNum = num.toCharArray();
        for (int i=0; i<lengthString; i++) {
            int currentDigit = convertedNum[i] - '0';
            if (change[currentDigit] > currentDigit) {
                convertedNum[i] = (char)(change[currentDigit] + '0');
                isWeStartedMutating = true;
            }
            else if (change[currentDigit] != currentDigit) {
                if (isWeStartedMutating)
                    return new String(convertedNum);
            }
        }
        return new String(convertedNum);
    }
}