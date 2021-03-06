class Solution {
    public boolean checkValidString(String s) {
        int maximumDifference = 0;
        int minimumDifference = 0;
        // 3 cases
        // ( || *->  maximumDifference ++ and minimumDifference ++ 
        // ) || * -> maximumDifference -- and minimumDifference --
        // * -> maximumDifference ++ and minimumDifference --
        // if the minimumDifference is still 0 after whole scanning, then it will be 0
        // Whenever minDiff falls below 0, we should force it to be 0 because we never accept negative diff during the process.
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                maximumDifference += 1;
                minimumDifference += 1;
            }
            else if (ch == ')') {
                maximumDifference -= 1;
                minimumDifference -= 1;
            }
            else {
                maximumDifference += 1;
                minimumDifference -= 1;
            }
            if (maximumDifference < 0)
                return false;
            minimumDifference = Math.max(0, minimumDifference);
        }
        return minimumDifference == 0;
    }
}
