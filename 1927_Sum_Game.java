// https://leetcode.com/problems/sum-game/discuss/1329069/Java-Greedy-O(n)-solution-with-detailed-explaination-covering-every-case

class Solution {
    public boolean sumGame(String num) {
        int length = num.length();
        int diffSum = 0;
        int leftQue = 0;
        int rightQue = 0;
        for (int i=0; i<length / 2; i++) {
            char current = num.charAt(i);
            if (current == '?') {
                leftQue += 1;
            }
            else {
                diffSum += current - '0';
            }
        }
        for (int i = length / 2; i < length; i++) {
            char current = num.charAt(i);
            if (current == '?') {
                rightQue += 1;
            }
            else {
                diffSum -= current - '0';
            }
        }
        if ((leftQue + rightQue) % 2 == 1)
            return true;
        if (leftQue == rightQue) {
            return diffSum != 0;
        }
        int round = (leftQue - rightQue) / 2;
        if (diffSum * round >= 0) {
            return true;
        }
        return Math.abs(diffSum) != Math.abs(round * 9);
    }
}