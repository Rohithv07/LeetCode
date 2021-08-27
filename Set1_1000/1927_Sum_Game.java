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



/*
* ref : https://www.youtube.com/watch?v=LBB2E69Qxc8
* Alice has the last turn, then alice wins
* even number of '?' should be there
* Smae number of question marks, they just cancels out
* Bob guarantee the sum equal to n/2 * 9

*/

class Solution {
    public boolean sumGame(String num) {
        int length = num.length();
        int balance = 0;
        for (int i=0; i<length; i++) {
            int number = 2 * (num.charAt(i) - '0');
            if (num.charAt(i) == '?') {
                number = 9;
            }
            if (i < length / 2) {
                balance += number;
            }
            else {
                balance -= number;
            }
        }
        return balance != 0;
    }
}